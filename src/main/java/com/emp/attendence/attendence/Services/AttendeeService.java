package com.emp.attendence.attendence.Services;

import com.emp.attendence.attendence.Entities.Attendance;
import com.emp.attendence.attendence.Entities.Attendee;
import com.emp.attendence.attendence.Repos.AttendeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AttendeeService {

    private final AttendeeRepo attendeeRepo;

    public boolean isPresent(Long id, LocalDate now) {
        Optional<Attendee> attendee = attendeeRepo.findById(id);
        if(attendee.isPresent()){
            List<Attendance> attendances = attendee.get().getListOfAttendance();
            for(Attendance attendance : attendances){
                if(attendance.getDate().equals(now) && attendance.isPresent()==true){
                    return true;
                }else if(attendance.getDate().equals(now)){
                    return false;
                }
            }
        }

        return false;
    }

    public void markAbsent(Long id, LocalDate date1) {
        Optional<Attendee> attendee = attendeeRepo.findById(id);
        if(attendee.isPresent()){
            List<Attendance> attendances = attendee.get().getListOfAttendance();
            for(Attendance attendance : attendances){
                if(attendance.getDate().equals(date1)){
                    attendance.setPresent(false);
                    break;
                }
            }

            attendeeRepo.save(attendee.get());
        }
    }

    public void markPresent(Long id, LocalDate date1) {
        Optional<Attendee> attendee = attendeeRepo.findById(id);
        if(attendee.isPresent()){
            List<Attendance> attendances = attendee.get().getListOfAttendance();
            boolean dateIsInTheList = false;
            for(Attendance attendance : attendances){
                if(attendance.getDate().equals(date1)){
                    dateIsInTheList = true;
                    attendance.setPresent(true);
                    attendeeRepo.save(attendee.get());
                    break;
                }
            }
            if(!dateIsInTheList){
                Attendance attendance = new Attendance(attendee.get().getId(), LocalDate.now(), true);
                attendances.add(attendance);
                attendeeRepo.save(attendee.get());
            }
        }
    }
}
