package com.naukma.springDbDemo.dao;

import com.naukma.springDbDemo.DbController;
import com.naukma.springDbDemo.entities.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateTeacherDao implements TeachersDao {

    private SessionFactory sessionFactory;

    private Session currentSession(){
        if(sessionFactory == null) {
            sessionFactory = (SessionFactory) DbController.getContext().getBean("sessionFactory");
        }
        return sessionFactory.getCurrentSession();
    }
    public void addTeacher(Teacher teacher) {
        currentSession().save(teacher);
    }
    public Teacher getTeacherById(int id) {
        return (Teacher) currentSession().get(Teacher.class, id);
    }
    public void saveTacher(Teacher teacher) {
        currentSession().update(teacher);
    }
}