package com.springHelloWorld.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String cityOfBirth;
    private String email;
    private String university;
    private Date dob;
}
