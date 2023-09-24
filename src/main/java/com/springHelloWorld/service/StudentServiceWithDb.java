package com.springHelloWorld.service;

import com.springHelloWorld.dto.StudentDto;
import com.springHelloWorld.exception.business.StudentNotFoundException;
import com.springHelloWorld.mapper.StudentMapper;
import com.springHelloWorld.model.Student;
import com.springHelloWorld.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceWithDb {

    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;//Field Injection

    public StudentServiceWithDb(@Qualifier("jpaStudentRepository") StudentRepository studentRepository) {//Constructor injection
        this.studentRepository = studentRepository;
    }

    public StudentDto getStudentById(int studentId)  {
        Optional<Student> studentById = null;//Method from JPA Repo, returns Optional
        studentById = studentRepository.findById(studentId);

        Student student = studentById.orElseGet(Student::new);//Return empty constructor if no data/Null
        //Throw custom Exception, in case business requirement is not to return empty data
        //Student student = student = studentById.orElseThrow(() -> new StudentNotFoundException("The Student with Id
        // " + studentId + " " + "does not exist"));

        //Convert the DB Model into Response DTO
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
