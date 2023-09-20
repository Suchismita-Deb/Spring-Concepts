package com.springHelloWorld.repository;

import com.springHelloWorld.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class StudentRepositoryDummyData {

    public Student getStudentById(int studentId){
        //Sending dummy student details.
        //TODO: Finish the database call.
        //Student student = callStudentDb(studentId);
        Student student = Student.builder()
                .id(studentId)
                .firstName("Suchi")
                .lastName("Deb")
                .cityOfBirth("XYZ")
                .dob(new Date())
                .email("ab@gmail.com")
                .gender("Female")
                .university("XYZ College")
                .build();
        return student;
    }

    public List<Student> getMultipleStudentByIds(List<Integer> studentIdList) {
        Student student1 = Student.builder()
                .id(3)
                .firstName("Suchi")
                .lastName("Deb")
                .cityOfBirth("XYZ")
                .dob(new Date())
                .email("ab@gmail.com")
                .gender("Female")
                .university("XYZ College")
                .build();


        Student student2 = Student.builder()
                .id(5)
                .firstName("Suchi1")
                .lastName("Deb1")
                .cityOfBirth("XYZ1")
                .dob(new Date())
                .email("ab@gmail.com")
                .gender("Female")
                .university("XYZ College1")
                .build();

        List<Student> studentList= new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        return studentList;
    }
}
