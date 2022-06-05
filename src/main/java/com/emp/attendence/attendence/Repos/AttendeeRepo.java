package com.emp.attendence.attendence.Repos;

import com.emp.attendence.attendence.Entities.Attendee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepo extends CrudRepository<Attendee, Long> {
}
