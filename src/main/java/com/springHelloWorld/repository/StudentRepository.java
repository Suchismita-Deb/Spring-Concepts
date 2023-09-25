package com.springHelloWorld.repository;

import com.springHelloWorld.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("jpaStudentRepository")
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Custom query
    @Query("SELECT * from student WHERE gender = 'Male'")
    List<Student> findAllMaleStudents();
}
