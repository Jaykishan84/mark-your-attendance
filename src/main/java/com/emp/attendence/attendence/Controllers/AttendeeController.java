package com.emp.attendence.attendence.Controllers;

import com.emp.attendence.attendence.Entities.Attendance;
import com.emp.attendence.attendence.Entities.Attendee;
import com.emp.attendence.attendence.Repos.AttendanceRepo;
import com.emp.attendence.attendence.Repos.AttendeeRepo;
import com.emp.attendence.attendence.Services.AttendeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class AttendeeController {

    private final AttendeeService attendeeService;
    private final AttendeeRepo attendeeRepo;
    private final AttendanceRepo attendanceRepo;


    @PostMapping("/addNewAttendee")
    public Attendee addNewAttendee(@RequestBody Attendee attendee){
        return attendeeRepo.save(attendee);
    }

    @GetMapping("/home")
    public String home(){
        return "Welcome!";
    }

    @GetMapping("/getAllAttendees")
    public Iterable<Attendee> getAllAttendees(){
        return attendeeRepo.findAll();
    }

    @PostMapping("/markAttendance")
    public String markAttendance(@RequestParam("id") Long id){
        Optional<Attendee> attendee = attendeeRepo.findById(id);
        if(attendee.isPresent()) {
            attendeeService.markPresent(id, LocalDate.now());
        }
        return "Attendence Succesfully Updated.";
    }

    @GetMapping("/getAttendanceById")
    public List<Attendance> getAttendanceById(@RequestParam("id") Long id){
        Optional<Attendee> attendee = attendeeRepo.findById(id);
        if(attendee.isPresent()){
            return attendee.get().getListOfAttendance();
        }else{
            return new ArrayList<>();
        }
    }

    @GetMapping("/getAttendanceByIdOnDateX")
    public String getAttendanceByIdOnDateX(@RequestParam("id") Long id, @RequestParam("date") String date){
        LocalDate date1 = LocalDate.parse(date);
        if(attendeeService.isPresent(id, date1)){
            return "Present.";
        }else{
            return "Absent.";
        }
    }

    @PostMapping("updateAttendance")
    public String updateAttendance(@RequestParam("id") Long id, @RequestParam("date") String date){
        LocalDate date1 = LocalDate.parse(date);
        if(attendeeService.isPresent(id, date1)){
            attendeeService.markAbsent(id, date1);
        }
        return "Updated Attendance Succesfully.";
    }
}
