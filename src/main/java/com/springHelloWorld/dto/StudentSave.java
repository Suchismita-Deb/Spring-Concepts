package com.springHelloWorld.dto;

import java.util.Date;

public record StudentSave(
    String firstName,
    String lastName,
    String gender,
    String cityofbirth,
    String email,
    String university,
    Date dob)
{}