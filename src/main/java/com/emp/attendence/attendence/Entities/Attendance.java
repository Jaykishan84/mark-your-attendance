package com.emp.attendence.attendence.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long attendeeId;
    private LocalDate date;
    private boolean isPresent;

    public Attendance(Long attendeeId, LocalDate date, boolean isPresent) {
        this.attendeeId = attendeeId;
        this.date = date;
        this.isPresent = isPresent;
    }

    public Attendance(Long attendeeId, LocalDate date) {
        this.attendeeId = attendeeId;
        this.date = date;
        this.isPresent = false;
    }
}
