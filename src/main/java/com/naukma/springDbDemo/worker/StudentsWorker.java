package com.naukma.springDbDemo.worker;

import com.naukma.springDbDemo.dao.StudentDao;
import com.naukma.springDbDemo.dao.TeacherDao;
import com.naukma.springDbDemo.entities.Student;
import com.naukma.springDbDemo.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentsWorker {
    @Autowired
    StudentDao studentDao;
    public Student addStudent(Student student) {
        student = studentDao.addStudent(student);
        System.out.println(student);
        return student;
    }
}
