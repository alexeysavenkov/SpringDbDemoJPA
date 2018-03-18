package com.naukma.springDbDemo.dao;

import com.naukma.springDbDemo.entities.Lecture;
import com.naukma.springDbDemo.entities.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Queue;

@Repository
@Transactional
public class LectureDaoJPAImpl implements LecturesDao{
    @PersistenceContext
    private EntityManager em;

    public Lecture addLecture(Lecture lecture) {
        em.persist(lecture);
        return lecture;
    }

    public Lecture getLecture(int id) {
        return em.find(Lecture.class,id);
    }

    public Collection<Lecture> findAllLectures() {
        Query query = em.createQuery("SELECT t FROM Lecture t");
        return (Collection<Lecture>) query.getResultList();
    }

    public void saveLecture(Lecture lecture) {
        em.merge(lecture);
    }

    @Transactional
    public String getLectureInfo(Lecture lecture) {
        StringBuilder sb = new StringBuilder();

        sb.append("Lecture " + lecture.getId() + "\n");

        sb.append("University " + lecture.getUniversity().toString() + "\n");
        sb.append("Teacher " + lecture.getTeacher().toString() + "\n");

        for(Student student : lecture.getStudents()) {
            sb.append("Student " + student.toString() + "\n");
        }

        sb.append("\n\n\n");

        return sb.toString();
    }
}