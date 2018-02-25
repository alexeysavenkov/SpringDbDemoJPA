package com.naukma.springDbDemo.worker;

import com.naukma.springDbDemo.entities.Student;
import com.naukma.springDbDemo.dao.StudentsDao;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentsWorker {
    @Autowired
    private StudentsDao studentsDao;

    public void saveStudentToDb(Student student){
        if ((student!=null)&&(student.getPib()!=null)&&(!"".equals(student.getPib()))&&(student.getCourse()>0)){
            studentsDao.addStudent(student);
            System.out.println("Student have been saved "+student);
        }
    }

    public Student getStudentById(int id) {
        return studentsDao.getStudentById(id);
    }
}