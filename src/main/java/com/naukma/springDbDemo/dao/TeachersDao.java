package com.naukma.springDbDemo.dao;

import com.naukma.springDbDemo.entities.Teacher;

public interface TeachersDao {
    void addTeacher(Teacher teacher);
    Teacher getTeacherById(int id);
    void saveTacher(Teacher teacher);
}