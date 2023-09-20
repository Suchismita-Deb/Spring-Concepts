package com.springHelloWorld.service;

import com.springHelloWorld.dto.StudentDto;
import com.springHelloWorld.model.Student;
import com.springHelloWorld.repository.StudentRepository;
import com.springHelloWorld.repository.StudentRepositoryDummyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceWithDb {

    @Autowired
    StudentRepository studentRepository;

    public StudentDto getStudentById(int studentId){
        Optional<Student> studentById = studentRepository.findById(studentId);
        StudentDto studentDto = getStudentDtoFromStudent(studentById.get());
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
        List<Student> studentDetailsList = studentRepository.findAllById(studentIdList);
        List<StudentDto> studentDtoList = new ArrayList<>();
        for(Student s:studentDetailsList){
            StudentDto singleStudentDto = getStudentDtoFromStudent(s);
            studentDtoList.add(singleStudentDto);
        }
        return studentDtoList;
    }
}
