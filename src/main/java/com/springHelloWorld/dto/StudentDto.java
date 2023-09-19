package com.springHelloWorld.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class StudentDto {
    private String fullName;
    private String city;
    private String sex;
    private String university;
    private String emailId;
}
