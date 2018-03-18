package com.naukma.springDbDemo.dao;

import com.naukma.springDbDemo.dao.TeacherDao;
import com.naukma.springDbDemo.entities.Student;
import com.naukma.springDbDemo.entities.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class StudentDaoJPAImpl implements StudentDao {
    @PersistenceContext
    private EntityManager em;

    public Student addStudent(Student student) {
        em.persist(student);
        return student;
    }

    public Student getStudent(int id){
        return em.find(Student.class,id);
    }

    public void saveStudent(Student student) {
        em.merge(student);
    }
}