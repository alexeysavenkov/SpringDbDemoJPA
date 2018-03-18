package com.naukma.springDbDemo.dao;


import com.naukma.springDbDemo.entities.Student;
import com.naukma.springDbDemo.entities.Teacher;

import java.util.Collection;

public interface StudentDao {

    Student addStudent(Student student);

    Student getStudent(int id);

    void saveStudent(Student student);

    Collection<Student> findByName(String name);

    Collection<Student> findByCourse(int course);

}