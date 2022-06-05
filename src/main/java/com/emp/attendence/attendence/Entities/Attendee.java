package com.emp.attendence.attendence.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<Attendance> listOfAttendance;

    public Attendee(String firstname, String lastname, String email, List<Attendance> listOfAttendance) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.listOfAttendance = listOfAttendance;
    }
}
