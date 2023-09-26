package com.springHelloWorld.controller;

import com.springHelloWorld.model.Student;
import com.springHelloWorld.service.StudentServiceWithPg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jdbc")
public class StudentPGController {
    private StudentServiceWithPg studentServiceWithPg;

    @Autowired
    public StudentPGController(StudentServiceWithPg studentServiceWithPg) {
        this.studentServiceWithPg = studentServiceWithPg;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getTutorialById(@PathVariable("id") int id) {
        Student student = studentServiceWithPg.getStudentByIdPgJdbc(id);

        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
