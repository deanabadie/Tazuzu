package com.tazuzuapp.api.activity.domain;

import com.tazuzuapp.api.general.domain.BaseEntity;
import com.tazuzuapp.api.user.domain.Student;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@SuppressWarnings("unused")
public class Activity extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long activityId;

    @NotNull
    private String activityName;

    private Long activityTypeId;

    private int numOfMeasurements;

    @ManyToMany
    @JoinTable(name = "activity_students", joinColumns = {
            @JoinColumn(name = "activity_id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "student_id", nullable = false, updatable = false)
    })
    private List<Student> participants;

    public Activity (){}

    public List<Student> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Student> participants) {
        this.participants = participants;
    }

    public Long getActivityTypeId() { return activityTypeId; }

    public void setActivityTypeId(Long activityTypeId) { this.activityTypeId = activityTypeId; }

    public String getActivityName() { return activityName; }

    public void setActivityName(String activityName) { this.activityName = activityName; }

    public Long getId() { return activityId; }

    public void setId(Long id) { this.activityId = id; }

    public void setNumOfMeasurements(int numOfMeasurements) {
        this.numOfMeasurements = numOfMeasurements;
    }

    public int getNumOfMeasurements() {
        return numOfMeasurements;
    }
}
