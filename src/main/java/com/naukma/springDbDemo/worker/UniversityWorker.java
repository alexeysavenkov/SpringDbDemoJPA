package com.naukma.springDbDemo.worker;

import com.naukma.springDbDemo.dao.LecturesDao;
import com.naukma.springDbDemo.dao.UniversityDao;
import com.naukma.springDbDemo.entities.Lecture;
import com.naukma.springDbDemo.entities.University;
import org.springframework.beans.factory.annotation.Autowired;

public class UniversityWorker {
    @Autowired
    UniversityDao universityDao;
    public University addUniversity(University university){
        university = universityDao.addUniversity(university);
        System.out.println(university);
        return university;
    }
}
