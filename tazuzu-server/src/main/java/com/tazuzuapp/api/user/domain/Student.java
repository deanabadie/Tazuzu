package com.tazuzuapp.api.user.domain;

import com.tazuzuapp.api.activity.domain.Activity;
import com.tazuzuapp.api.organization.domain.Class;
import com.tazuzuapp.api.organization.domain.School;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@SuppressWarnings("unused")
public class Student extends User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long govId;

    @NotNull
    private double height;

    @NotNull
    private double weight;

    @NotNull
    @ManyToOne
    private School school;

    @NotNull
    @ManyToOne
    private Class schoolClass;

    @ManyToMany
    private List<Activity> activities;

//
//    @NotNull
//    private Date dateOfBirth;

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
//        this.setDateOfBirth(sr.getDateOfBirth());
//        this.setSchool(sr.getSchoolName());
//        this.setSchoolClass(sr.getSchoolClass());
    }
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id){
        this.id = id;
    }

    public Long getGovId() {
        return govId;
    }

    public void setGovId(Long govId) {
        this.govId = govId;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Class getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(Class schoolClass) {
        this.schoolClass = schoolClass;
    }
//
//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(Date dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
}
