package com.naukma.springDbDemo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="findByName", query="SELECT t FROM Student t WHERE t.pib LIKE :name"),
        @NamedQuery(name="findByCourse", query="SELECT t FROM Student t WHERE t.course = :course")
})
@Table(name="Students")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String pib;
    private int course;

    public List<Lecture> getUniversity() {
        return university;
    }

    public void setUniversity(List<Lecture> university) {
        this.university = university;
    }

    @ManyToMany(mappedBy = "students")
    private List<Lecture> university;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", pib='" + pib + '\'' +
                ", course=" + course +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
