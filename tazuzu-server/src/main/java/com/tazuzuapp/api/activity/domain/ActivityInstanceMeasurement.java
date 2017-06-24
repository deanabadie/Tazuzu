package com.tazuzuapp.api.activity.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tazuzuapp.api.general.domain.BaseEntity;
import com.tazuzuapp.api.user.domain.Student;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean participationApproval;

    @JsonIgnore
    private String participationApprovalToken;

    public ActivityInstanceMeasurement() {
        this.participationApproval = false;
    }

    public Long getId() {
        return id;
    }

    public ActivityInstanceMeasurement setId(Long id) {
        this.id = id;
        return this;
    }

    public ActivityInstance getActivityInstance() {
        return activityInstance;
    }

    public ActivityInstanceMeasurement setActivityInstance(ActivityInstance activityInstance) {
        this.activityInstance = activityInstance;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public ActivityInstanceMeasurement setStudent(Student student) {
        this.student = student;
        return this;
    }

    public Double getResultDistance() {
        return resultDistance;
    }

    public ActivityInstanceMeasurement setResultDistance(Double resultDistance) {
        this.resultDistance = resultDistance;
        return this;
    }

    public Integer getResultQuantity() {
        return resultQuantity;
    }

    public ActivityInstanceMeasurement setResultQuantity(Integer resultQuantity) {
        this.resultQuantity = resultQuantity;
        return this;
    }

    public Long getResultTimeSeconds() {
        return resultTimeSeconds;
    }

    public ActivityInstanceMeasurement setResultTimeSeconds(Long resultTimeSeconds) {
        this.resultTimeSeconds = resultTimeSeconds;
        return this;
    }

    public Double getGrade() {
        return grade;
    }

    public ActivityInstanceMeasurement setGrade(Double grade) {
        this.grade = grade;
        return this;
    }

    public boolean getParticipationApproval() {
        return participationApproval;
    }

    public ActivityInstanceMeasurement setParticipationApproval(boolean participationApproval) {
        this.participationApproval = participationApproval;
        return this;
    }

    public String getParticipationApprovalToken() {
        return participationApprovalToken;
    }

    public ActivityInstanceMeasurement setParticipationApprovalToken(String participationApprovalToken) {
        this.participationApprovalToken = participationApprovalToken;
        return this;
    }
}
