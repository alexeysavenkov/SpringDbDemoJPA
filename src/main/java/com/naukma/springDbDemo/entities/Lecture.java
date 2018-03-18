package com.naukma.springDbDemo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Lectures")
public class Lecture {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    private String name;
    private double credits;


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "universityId", nullable = false)
    private University university;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "teacherId", nullable = false)
    private Teacher teacher;

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", university=" + university +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }

    @ManyToMany(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
    @JoinTable(name = "lectures_students",
            joinColumns = @JoinColumn(name = "lectureId"),
            inverseJoinColumns = @JoinColumn(name = "studentId"))
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
//    public int getTeacherId() {
//        return teacherId;
//    }
//
//    public void setTeacherId(int teacherId) {
//        this.teacherId = teacherId;
//    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
//        this.teacherId = teacher.getTeacherId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

//    public int getUniversityId() {
//        return universityId;
//    }
//
//    public void setUniversityId(int universityId) {
//        this.universityId = universityId;
//    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
//        this.universityId = university.getId();
    }
}