package com.springHelloWorld.service;

import com.springHelloWorld.dto.StudentDto;
import com.springHelloWorld.dto.StudentPgDto;
import com.springHelloWorld.mapper.StudentMapper;
import com.springHelloWorld.model.Student;
import com.springHelloWorld.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceWithPg {
    private StudentRepository studentRepository;
    private StudentMapper mapper;

    @Autowired
    public StudentServiceWithPg(StudentRepository studentRepository, StudentMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    public List<StudentPgDto> getStudentById()  {
        List<Student> maleStudents = studentRepository.findAllMaleStudents();

        //Convert the DB Model into Response DTO
        /*List<StudentPgDto> studentPgDtos = maleStudents.stream()
                //.map()//TODO:
                .collect(Collectors.toList());
*/
        return null;
    }
}
