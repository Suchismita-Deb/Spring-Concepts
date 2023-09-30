package com.springHelloWorld.controller;

import com.springHelloWorld.dto.StudentSave;
import com.springHelloWorld.model.Student;
import com.springHelloWorld.service.StudentServiceWithDb;
import com.springHelloWorld.service.StudentServiceWithPg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class StudentPGController {

    private StudentServiceWithPg studentServiceWithPg;

    @Autowired
    public StudentPGController(StudentServiceWithPg studentServiceWithPg) {
        this.studentServiceWithPg = studentServiceWithPg;
    }

    @PutMapping(value = "/student/save",
            produces = "application/json")
    public int saveStudent(@RequestBody StudentSave student) {
        return studentServiceWithPg.saveStudent(student);
    }
}
