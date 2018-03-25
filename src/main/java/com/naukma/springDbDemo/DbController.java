package com.naukma.springDbDemo;

import com.naukma.springDbDemo.entities.*;
import com.naukma.springDbDemo.worker.LecturesWorker;
import com.naukma.springDbDemo.worker.StudentsWorker;
import com.naukma.springDbDemo.worker.TeachersWorker;
import com.naukma.springDbDemo.worker.UniversityWorker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.nio.cs.UnicodeEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class DbController {

    @RequestMapping("program-tx-test")
    public String programTxTest() {
        ApplicationContext context = getContext();

        TeachersWorker teachersWorker = (TeachersWorker) getContext().getBean("teacher-worker");

        // Adds two teachers
        teachersWorker.programTransactionTestSuccess();

        // Adds nothing
        teachersWorker.programTransactionTestFail();


        return "SUCCESS";
    }

    @RequestMapping("container-tx-test")
    public String containerTxTest() {
        ApplicationContext context = getContext();

        TeachersWorker teachersWorker = (TeachersWorker) getContext().getBean("teacher-worker");

        // Adds two teachers
        teachersWorker.containerTransactionTestSuccess();

        try {
            // Adds nothing
            teachersWorker.containerTransactionTestFailure();
        } catch(RuntimeException e) {

        }

        return "SUCCESS";
    }

    @RequestMapping("generate-test-db")
    public String generateTestDb() {
        ApplicationContext context = getContext();

        University university = new University();
        Teacher teacher = new Teacher();
        Lecture lecture = new Lecture();
        List<Student> students = new ArrayList<>();

        {
            Student student = new Student();
            student.setCourse(3);
            student.setPib("Savenkov Oleksii");

            StudentsWorker worker =
                    (StudentsWorker) context.getBean("stud-worker");

            students.add(worker.addStudent(student));

            Student student2 = new Student();
            student2.setCourse(4);
            student2.setPib("Name Surname");

            students.add(worker.addStudent(student2));
        }

        {

            university.setName("NAUKMA");

            Address address = new Address();
            address.setCity("Kyiv");
            address.setCountry("Ukraine");
            address.setStreet1("Skovorody");
            address.setStreet2("2");
            address.setZipcode("05555");
            address.setState("Kyiv");

            university.setAddress(address);
            university.setCreationDate(new Date(1615, 1, 1));

            UniversityWorker worker = (UniversityWorker) context.getBean("uni-worker");
            university = worker.addUniversity(university);
        }

        {
            TeachersWorker teachersWorker =
                    (TeachersWorker) getContext().getBean("teacher-worker");
            teacher.setFirstname("Andrii");
            teacher.setLastname("Glybovets");
            teacher.setCellPhone("+380675097865");
            teacher.setBirthDate(new Date());
            teacher = teachersWorker.addTeacher(teacher);
        }

        {
            lecture.setName("Introduction to Spring");
            lecture.setCredits(2.5);
            lecture.setUniversity(university);
            lecture.setTeacher(teacher);
            lecture.setStudents(students);
            LecturesWorker worker = (LecturesWorker) context.getBean("lecture-worker");
            lecture = worker.addLecture(lecture);
        }


        return "SUCCESS";
    }

    @RequestMapping("test-queries")
    @Transactional
    public String queryTest() {
        ApplicationContext context = getContext();

        LecturesWorker worker = (LecturesWorker) context.getBean("lecture-worker");

        StringBuilder sb = new StringBuilder();

        for(Lecture lecture : worker.findAllLectures()) {
            sb.append(worker.getLectureInfo(lecture));
        }

        return sb.toString();
    }

    @RequestMapping("naukma")
    public String naukma() {
        ApplicationContext context = getContext();

        UniversityWorker worker = (UniversityWorker) context.getBean("uni-worker");

        return worker.findNaukma().toString();
    }

    @RequestMapping("glybovets")
    public String glybovets() {
        ApplicationContext context = getContext();

        TeachersWorker worker = (TeachersWorker) context.getBean("teacher-worker");

        return worker.findGlybovets().toString();
    }

    public static ApplicationContext getContext() {
        return new ClassPathXmlApplicationContext("app-config.xml");
    }

}
