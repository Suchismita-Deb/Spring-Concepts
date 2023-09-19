package com.springHelloWorld.service;

import com.springHelloWorld.dto.StudentDto;
import com.springHelloWorld.model.Student;
import com.springHelloWorld.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public StudentDto getStudentById(int studentId){
        Student studentById = studentRepository.getStudentById(studentId);
        StudentDto studentDto = getStudentDtoFromStudent(studentById);

        return studentDto;
    }

    private static StudentDto getStudentDtoFromStudent(Student studentById) {
        return StudentDto.builder()
                .fullName(studentById.getFirstName() + " " + studentById.getLastName())
                .city(studentById.getCityOfBirth())
                .sex(studentById.getGender())
                .university(studentById.getUniversity())
                .emailId(studentById.getEmail())//TODO: The email validation.
                .build();
    }

    public List<StudentDto> getStudentByIds(List<Integer> studentIdList) {
        List<Student> studentDetailsList = studentRepository.getMultipleStudentByIds(studentIdList);
        List<StudentDto> studentDtoList = new ArrayList<>();
        for(Student s:studentDetailsList){
            StudentDto singleStudentDto = getStudentDtoFromStudent(s);
            studentDtoList.add(singleStudentDto);
        }
        return studentDtoList;
    }
}
