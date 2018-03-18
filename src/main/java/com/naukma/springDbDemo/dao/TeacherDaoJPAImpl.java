package com.naukma.springDbDemo.dao;

import com.naukma.springDbDemo.entities.Teacher;
import com.naukma.springDbDemo.entities.University;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class TeacherDaoJPAImpl implements TeacherDao {
    @PersistenceContext
    private EntityManager em;

    public Teacher addTeacher(Teacher teacher) {
        em.persist(teacher);
        return teacher;
    }

    public Teacher getTeacher(int id){
        return em.find(Teacher.class,id);
    }

    public void saveTeacher(Teacher teacher) {
        em.merge(teacher);
    }

    @Override
    public Teacher findGlybovets() {
        return (Teacher)em.createNamedQuery("findGlybovets").getSingleResult();
    }
}