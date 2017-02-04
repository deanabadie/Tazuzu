package com.tazuzu.user.domain;

import com.tazuzu.organization.domain.School;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private String schoolName;

    @NotNull
    private String schoolClass;

    public Student() {}

    @Override
    public Long getId() {
        return id;
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

    public String getSchoolName() {
        return schoolName;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
