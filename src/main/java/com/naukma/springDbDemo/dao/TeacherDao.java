package com.naukma.springDbDemo.dao;


import com.naukma.springDbDemo.entities.Teacher;
import com.naukma.springDbDemo.entities.University;

public interface TeacherDao {

    Teacher addTeacher(Teacher teacher);

    Teacher getTeacher(int id);

    void saveTeacher(Teacher teacher);

}