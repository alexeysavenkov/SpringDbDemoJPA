package com.naukma.springDbDemo.worker;

import com.naukma.springDbDemo.dao.LecturesDao;
import com.naukma.springDbDemo.entities.Lecture;
import com.naukma.springDbDemo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public class LecturesWorker {
    @Autowired
    LecturesDao lecturesDao;

    @Transactional
    public Lecture addLecture(Lecture lecture){
        lecture = lecturesDao.addLecture(lecture);
        System.out.println(lecture);
        return lecture;
    }

    public void updateLecture(Lecture lecture) {
        lecturesDao.saveLecture(lecture);
    }

    public Collection<Lecture> findAllLectures() {
        return lecturesDao.findAllLectures();
    }

    @Transactional
    public String getLectureInfo(Lecture lecture) {
        return lecturesDao.getLectureInfo(lecture);
    }
}
