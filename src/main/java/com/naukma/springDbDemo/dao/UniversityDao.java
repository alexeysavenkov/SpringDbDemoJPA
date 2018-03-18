package com.naukma.springDbDemo.dao;


import com.naukma.springDbDemo.entities.Lecture;
import com.naukma.springDbDemo.entities.University;

public interface UniversityDao {

    University addUniversity(University lecture);

    University getUniversity(int id);

    void saveUniversity(University lecture);

}