package com.naukma.springDbDemo.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Teachers")
public class Teacher {
    @Id
    @GeneratedValue
    private int teacherId;

    private String firstname;

    private String lastname;

    private Date birthDate;

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

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDate=" + birthDate +
                ", cellPhone='" + cellPhone + '\'' +
                '}';
    }
}