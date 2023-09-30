package com.springHelloWorld.dao.pg;

import com.springHelloWorld.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class PgJdbcTemplate{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Student runQueryAndGetResult(int id) {

        Student student = null;
        try {
            student = jdbcTemplate.queryForObject("SELECT * FROM student WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Student.class), id);

        } catch (IncorrectResultSizeDataAccessException e) {
            System.out.println(e.getMessage());
            ;
        }
        return student;
    }

    public Student saveSingleStudentAndGetResult(Student student){
        int id = student.getId();
        jdbcTemplate.execute("INSERT INTO users (id,firstName,lastName) VALUES ('Joe', 'Cool') RETURNING id;",);
    }
}
