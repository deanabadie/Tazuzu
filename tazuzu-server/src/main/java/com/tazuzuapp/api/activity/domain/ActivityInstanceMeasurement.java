package com.tazuzuapp.api.activity.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tazuzuapp.api.general.domain.BaseEntity;
import com.tazuzuapp.api.user.domain.Student;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.Duration;

@Entity
public class ActivityInstanceMeasurement extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    private ActivityInstance activityInstance;

    @ManyToOne
    private Student student;

    private Double resultDistance;

    private Integer resultQuantity;

    private Long resultTimeSeconds;

    private Double grade;

    public ActivityInstance getActivityInstance() {
        return activityInstance;
    }

    public void setActivityInstance(ActivityInstance activityInstance) {
        this.activityInstance = activityInstance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getResultDistance() {
        return resultDistance;
    }

    public void setResultDistance(Double resultDistance) {
        this.resultDistance = resultDistance;
    }

    public Integer getResultQuantity() {
        return resultQuantity;
    }

    public void setResultQuantity(Integer resultQuantity) {
        this.resultQuantity = resultQuantity;
    }

    public Long getResultTimeSeconds() {
        return resultTimeSeconds;
    }

    public void setResultTimeSeconds(Long resultTimeSeconds) {
        this.resultTimeSeconds = resultTimeSeconds;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

}
