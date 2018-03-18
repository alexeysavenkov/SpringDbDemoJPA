package com.naukma.springDbDemo.worker;

import com.naukma.springDbDemo.dao.TeacherDao;
import com.naukma.springDbDemo.dao.UniversityDao;
import com.naukma.springDbDemo.entities.Teacher;
import com.naukma.springDbDemo.entities.University;
import org.springframework.beans.factory.annotation.Autowired;

public class TeachersWorker {
    @Autowired
    TeacherDao teacherDao;
    public Teacher addTeacher(Teacher teacher) {
        teacher = teacherDao.addTeacher(teacher);
        System.out.println(teacher);
        return teacher;
    }
}
