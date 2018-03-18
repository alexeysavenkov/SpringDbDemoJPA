package com.naukma.springDbDemo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Universities")
public class University {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    private String name;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "university")
    private List<Lecture> lectures;

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", address=" + address +
                '}';
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Embedded
    private Address address;

}
