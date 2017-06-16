package com.tazuzuapp.api.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tazuzuapp.api.organization.domain.Class;
import com.tazuzuapp.api.organization.domain.School;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@SuppressWarnings("unused")
public class Student extends User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    private double height;

    @NotNull
    private double weight;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @NotNull
    @ManyToOne
    private Class schoolClass;

    @JsonIgnore
    @NotNull
    @ManyToOne
    private Teacher teacher;

    public Student() {}

    public Student(StudentRequest sr){
        this.setUserName(sr.getUserName());
        this.setFirstName(sr.getFirstName());
        this.setLastName(sr.getLastName());
        this.setEmail(sr.getEmail());
        this.setPhotoPath(sr.getPhotoPath());
        this.setActivated(true);
        this.setGender(sr.getGender());
        this.setGovId(sr.getGovId());
        this.setHeight(sr.getHeight());
        this.setWeight(sr.getWeight());
        this.setPassword(sr.getPassword());
        this.setDateOfBirth(sr.getDateOfBirth());
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id){
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Class getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(Class schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
