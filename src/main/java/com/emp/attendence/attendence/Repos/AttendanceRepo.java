package com.emp.attendence.attendence.Repos;

import com.emp.attendence.attendence.Entities.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepo extends CrudRepository<Attendance, Long> {
}
