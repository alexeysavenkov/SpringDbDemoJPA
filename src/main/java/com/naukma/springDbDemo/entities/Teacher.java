package com.naukma.springDbDemo.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TEACHERS")
public class Teacher {
    @Id
    @GeneratedValue
    private int teacherId;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="birthDate")
    private Date birthDate;

    @Column(name="cellPhone")
    private String cellPhone;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellphone) {
        this.cellPhone = cellphone;
    }
}