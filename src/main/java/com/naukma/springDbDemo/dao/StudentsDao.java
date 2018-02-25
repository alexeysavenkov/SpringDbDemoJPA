package com.naukma.springDbDemo.dao;

import com.naukma.springDbDemo.entities.Student;

public interface StudentsDao {
    void addStudent(Student student);
    public Student getStudentById(int id);
}