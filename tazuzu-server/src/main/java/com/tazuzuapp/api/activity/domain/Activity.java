package com.tazuzuapp.api.activity.domain;

import com.tazuzuapp.api.general.domain.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @NotNull
    private long LastEditedBy;

    public Activity (){}

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

    public void setLastEditedBy(long lastEditedBy) {
        LastEditedBy = lastEditedBy;
    }
}
