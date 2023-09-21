package com.springHelloWorld.service;

import com.springHelloWorld.dto.StudentDto;
import com.springHelloWorld.mapper.StudentMapper;
import com.springHelloWorld.model.Student;
import com.springHelloWorld.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceWithDb {
    @Autowired StudentRepository studentRepository;
    @Autowired StudentMapper studentMapper;

    public StudentDto getStudentById(int studentId){
        Optional<Student> studentById = studentRepository.findById(studentId);//Method from JPA Repo, returns Optional
        Student student = studentById.orElseGet(Student::new);//Return empty constructor if no data/Null
        //student = studentById.orElseGet(() -> new Student());
        //student = studentById.orElseGet(() -> Student.builder().build());

        StudentDto studentDto = studentMapper.convert(student);//Convertor/Mapper/Transformer
        return studentDto;
    }

    public List<StudentDto> getStudentByIds(List<Integer> studentIdList) {
        List<Student> studentDetailsList = studentRepository.findAllById(studentIdList);

        List<StudentDto> studentDtoList = studentDetailsList.stream()
                .map(studentMapper::convert)
                .collect(Collectors.toList());
        return studentDtoList;
    }
}
