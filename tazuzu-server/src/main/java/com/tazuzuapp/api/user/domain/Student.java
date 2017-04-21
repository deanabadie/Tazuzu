package com.tazuzuapp.api.user.domain;

import com.tazuzuapp.api.activity.domain.Activity;
import com.tazuzuapp.api.activity.domain.Test;
import com.tazuzuapp.api.organization.domain.Class;
import com.tazuzuapp.api.organization.domain.School;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

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
    @ManyToOne
    private School school;

    @NotNull
    @ManyToOne
    private Class schoolClass;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "participantsStudents")
    private List<Test> activities;

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

    public List<Test> getActivities() {
        return activities;
    }

    public void setActivities(List<Test> activities) {
        this.activities = activities;
    }
}
