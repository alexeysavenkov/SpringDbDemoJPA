package com.naukma.springDbDemo.dao;

import com.naukma.springDbDemo.entities.Lecture;
import com.naukma.springDbDemo.entities.University;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UniversityDaoJPAImpl implements UniversityDao {
    @PersistenceContext
    private EntityManager em;

    public University addUniversity(University university) {
        em.persist(university);
        return university;
    }

    public University getUniversity(int id) {
        return em.find(University.class,id);
    }

    public void saveUniversity(University university) {
        em.merge(university);
    }

    @Override
    public University findNaukma() {
        return (University) em.createNamedQuery("findNaukma").getSingleResult();
    }
}