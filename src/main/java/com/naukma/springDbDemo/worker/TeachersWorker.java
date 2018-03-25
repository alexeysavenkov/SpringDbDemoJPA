package com.naukma.springDbDemo.worker;

import com.naukma.springDbDemo.dao.TeacherDao;
import com.naukma.springDbDemo.dao.UniversityDao;
import com.naukma.springDbDemo.entities.Teacher;
import com.naukma.springDbDemo.entities.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;

public class TeachersWorker {
    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    TeacherDao teacherDao;

    public Teacher addTeacher(Teacher teacher) {
        teacher = teacherDao.addTeacher(teacher);
        System.out.println(teacher);
        return teacher;
    }

    public Teacher findGlybovets() {
        return teacherDao.findGlybovets();
    }

    public void programTransactionTestSuccess() {
        Teacher teacher1 = new Teacher();
        teacher1.setFirstname("Andrii");
        teacher1.setLastname("Hlybovets1");
        teacher1.setCellPhone("123321123");
        teacher1.setBirthDate(new Date());

        Teacher teacher2 = new Teacher();
        teacher2.setFirstname("Andrii");
        teacher2.setLastname("Hlybovets1");
        teacher2.setCellPhone("123321123");
        teacher2.setBirthDate(new Date());


        transactionTemplate.execute(new TransactionCallback<Void>() {

            @Override
            public Void doInTransaction(TransactionStatus txStatus) {
                try {
                    teacherDao.addTeacher(teacher1);
                    teacherDao.addTeacher(teacher2);
                    System.out.println("Teachers have been added");
                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }

                return null;
            }
        });

    }

    public void programTransactionTestFail() {
        Teacher teacher1 = new Teacher();
        teacher1.setFirstname("Andrii");
        teacher1.setLastname("Hlybovets1");
        teacher1.setCellPhone("123321123");
        teacher1.setBirthDate(new Date());

        Teacher teacher2 = new Teacher();
        teacher2.setFirstname("Andrii");
        teacher2.setLastname("Hlybovets1");
        teacher2.setCellPhone("123321123");
        teacher2.setBirthDate(new Date());

        Teacher[] teachersToAdd = new Teacher[]{teacher1, teacher2};

        transactionTemplate.execute(new TransactionCallback<Void>() {

            @Override
            public Void doInTransaction(TransactionStatus txStatus) {
                try {
                    teacherDao.addTeacher(teacher1);
                    teacherDao.addTeacher(teacher2);
                    throw new RuntimeException("test");
                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                }

                return null;
            }
        });
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public void containerTransactionTestSuccess() {
        Teacher teacher1 = new Teacher();
        teacher1.setFirstname("Andrii");
        teacher1.setLastname("Hlybovets1");
        teacher1.setCellPhone("123321123");
        teacher1.setBirthDate(new Date());

        Teacher teacher2 = new Teacher();
        teacher2.setFirstname("Andrii");
        teacher2.setLastname("Hlybovets1");
        teacher2.setCellPhone("123321123");
        teacher2.setBirthDate(new Date());

        teacherDao.addTeacher(teacher1);
        teacherDao.addTeacher(teacher2);
        System.out.println("Teachers have been added");

    }

    @Transactional(propagation= Propagation.REQUIRED)
    public void containerTransactionTestFailure() {
        Teacher teacher1 = new Teacher();
        teacher1.setFirstname("Andrii");
        teacher1.setLastname("Hlybovets1");
        teacher1.setCellPhone("123321123");
        teacher1.setBirthDate(new Date());

        Teacher teacher2 = new Teacher();
        teacher2.setFirstname("Andrii");
        teacher2.setLastname("Hlybovets1");
        teacher2.setCellPhone("123321123");
        teacher2.setBirthDate(new Date());

        teacherDao.addTeacher(teacher1);
        teacherDao.addTeacher(teacher2);

        throw new RuntimeException("test");

    }
}
