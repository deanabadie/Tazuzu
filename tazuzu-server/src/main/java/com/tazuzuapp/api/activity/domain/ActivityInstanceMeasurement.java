package com.tazuzuapp.api.activity.domain;

import com.tazuzuapp.api.general.domain.BaseEntity;
import com.tazuzuapp.api.user.domain.Student;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

import java.time.Duration;

@Entity
public class ActivityInstanceMeasurement extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long ActivityInstanceMeasurmentId;

    @NotEmpty
    @ManyToOne
    private ActivityInstance activityInstance;

    @ManyToOne
    private Student student;

    private Double resultDistance;

    private Integer resultQuantity;

    private Duration resultTime;

    private Double grade;

    public ActivityInstance getActivityInstance() {
        return activityInstance;
    }

    public void setActivityInstance(ActivityInstance activityInstance) {
        this.activityInstance = activityInstance;
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

    public Duration getResultTime() {
        return resultTime;
    }

    public void setResultTime(Duration resultTime) {
        this.resultTime = resultTime;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
