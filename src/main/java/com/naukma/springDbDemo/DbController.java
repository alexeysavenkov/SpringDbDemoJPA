package com.naukma.springDbDemo;

import com.naukma.springDbDemo.entities.Student;
import com.naukma.springDbDemo.entities.Teacher;
import com.naukma.springDbDemo.worker.StudentsWorker;
import com.naukma.springDbDemo.worker.TeachersWorker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@RestController
public class DbController {

    @RequestMapping("/db-write-demo")
    public String dbWrite() {
        ApplicationContext context = getContext();
        StudentsWorker worker =
                (StudentsWorker) context.getBean("worker");

        Student testStudent = new Student("Savenkov Oleksii", 5);
        worker.saveStudentToDb(testStudent);

        return "SUCCESS";
    }

    @RequestMapping(value="/db-read-demo", params={"id"})
    public String dbRead(int id) {
        ApplicationContext context = getContext();
        StudentsWorker worker =
                (StudentsWorker) context.getBean("worker");

        Student student = worker.getStudentById(id);

        if(student == null) {
            return "Student not found";
        }

        return student.toString();
    }

    @RequestMapping("/hibernate-demo")
    public String hibernateDemo() {
        TeachersWorker teachersWorker =
                (TeachersWorker) getContext().getBean("teachersWorker");
        Teacher teacher = new Teacher();
        teacher.setFirstname("Andrii");
        teacher.setLastname("Glybovets");
        teacher.setCellPhone("+380675097865");
        teacher.setBirthDate(new Date());
        teacher = teachersWorker.addTeacher(teacher);
        teachersWorker.saveTacher(teacher);

        return "SUCCESS";
    }

    public static ApplicationContext getContext() {
        return new ClassPathXmlApplicationContext("app-config.xml");
    }

}
