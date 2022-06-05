package com.emp.attendence.attendence.Services;

import com.emp.attendence.attendence.Repos.AttendanceRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AttendanceService {

    private final AttendanceRepo attendanceRepo;
}
