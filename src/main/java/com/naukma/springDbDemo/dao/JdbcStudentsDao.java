package com.naukma.springDbDemo.dao;


import com.naukma.springDbDemo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcStudentsDao implements StudentsDao{

    private static final String SQL_INSERT_STUDENT = "insert into students (pib,course) values (?,?)";
    private static final String SQL_SELECT_STUDENT_BY_ID = "select id, pib, course from students where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addStudent(Student student) {

        jdbcTemplate.update(SQL_INSERT_STUDENT,
                student.getPib(),
                student.getCourse());
    }

    public Student getStudentById(int id){
        return jdbcTemplate.queryForObject(SQL_SELECT_STUDENT_BY_ID,
                new RowMapper<Student>() {
                    public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
                        Student student = new Student();
                        student.setStudentId(rs.getInt(1));
                        student.setPib(rs.getString(2));
                        student.setCourse(rs.getInt(3));
                        return student;
                    }
                },id);
    }
}