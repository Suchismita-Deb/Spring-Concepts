package com.springHelloWorld.controller;

import com.springHelloWorld.dto.StudentDto;
import com.springHelloWorld.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController(value = "Rest controller for student")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/{studentId}", path = "/{studentId}",
            consumes = {MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = { MediaType.APPLICATION_XML_VALUE, "application/json", MediaType.APPLICATION_PDF_VALUE})
    public StudentDto getStudentById(@PathVariable String studentId){
        int studentIntId = Integer.valueOf(studentId);
        StudentDto studentDetailById = studentService.getStudentById(studentIntId);
        return studentDetailById;
    }

    @RequestMapping(path = "/requestMapping/{studentId}",
            produces = { MediaType.APPLICATION_XML_VALUE, "application/json", MediaType.APPLICATION_PDF_VALUE})
    public @ResponseBody StudentDto getStudentByIdRequestMapping(@PathVariable String studentId){
        int studentIntId = Integer.valueOf(studentId);
        StudentDto studentDetailById = studentService.getStudentById(studentIntId);
        return studentDetailById;
    }

    @PostMapping(path = "/studentIds",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {"application/json"})
    public List<StudentDto> getStudentByIds(@RequestBody Map<String,List<Integer>> mapStudentIds){
        List<Integer> studentIdList = mapStudentIds.get("studentIds");
        List<StudentDto> studentDetailById = studentService.getStudentByIds(studentIdList);
        return studentDetailById;
    }
}
