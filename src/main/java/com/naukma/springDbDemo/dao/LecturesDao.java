package com.naukma.springDbDemo.dao;


import com.naukma.springDbDemo.entities.Lecture;

import java.util.Collection;

public interface LecturesDao {

    Lecture addLecture(Lecture lecture);

    Lecture getLecture(int id);

    Collection<Lecture> findAllLectures();

    void saveLecture(Lecture lecture);

    String getLectureInfo(Lecture lecture);
}