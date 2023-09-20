package com.springHelloWorld.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class Student {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String cityOfBirth;
    private String email;
    private String university;
    private Date dob;
}
