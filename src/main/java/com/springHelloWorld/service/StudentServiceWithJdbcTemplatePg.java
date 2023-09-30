package com.springHelloWorld.service;

import com.springHelloWorld.dao.pg.PgJdbcTemplate;
import com.springHelloWorld.dto.StudentPGRequestBody;
import com.springHelloWorld.dto.StudentPgDto;
import com.springHelloWorld.mapper.StudentMapper;
import com.springHelloWorld.model.Student;
import com.springHelloWorld.dao.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentServiceWithJdbcTemplatePg {
    private StudentRepository studentRepository;
    private StudentMapper mapper;

    private PgJdbcTemplate pgJdbcTemplate;


    @Autowired
    public StudentServiceWithJdbcTemplatePg(@Qualifier("jpaStudentRepository") StudentRepository studentRepository, StudentMapper mapper, PgJdbcTemplate pgJdbcTemplate) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
        this.pgJdbcTemplate = pgJdbcTemplate;
    }

    public List<StudentPgDto> getStudentById()  {
        List<Student> maleStudents = studentRepository.findMaleStudents();

        //Convert the DB Model into Response DTO
        /*List<StudentPgDto> studentPgDtos = maleStudents.stream()
                //.map()//TODO:
                .collect(Collectors.toList());
*/
        return null;
    }

    public Student getStudentByIdPgJdbc(int id){
        Student student = pgJdbcTemplate.runQueryAndGetResult(id);

        return student;

    }
    public Student saveSingleStudentPgJdbc(@RequestBody StudentPGRequestBody studentPGRequestBody){
        int newId = 1002;
        Student sDetail = Student.builder()
                .id(newId)
                .firstName(studentPGRequestBody.getFirstName())
                .lastName(studentPGRequestBody.getLastName())
                .gender(studentPGRequestBody.getGender())
                .cityofbirth(studentPGRequestBody.getCityofbirth())
                .email(studentPGRequestBody.getFirstName())
                .university(studentPGRequestBody.getUniversity())
                .dob(studentPGRequestBody.getDob())
                .build();

    }
}
