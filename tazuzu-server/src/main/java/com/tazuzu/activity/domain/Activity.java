package com.tazuzu.activity.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@SuppressWarnings("unused")
public class Activity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long activityId;

    @NotNull
    private String activityName;

    private Long activityTypeId;

    private int numOfMeasurements;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date TimeOfCreation;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date TimeOfLastEdit;

    @NotNull
    private long LastEditedBy;

    public Activity (){}

    public Long getActivityTypeId() { return activityTypeId; }

    public void setActivityTypeId(Long activityTypeId) { this.activityTypeId = activityTypeId; }

    public String getActivityName() { return activityName; }

    public void setActivityName(String activityName) { this.activityName = activityName; }

    public int getNumOfMeasurents() { return numOfMeasurements; }

    public void setNumOfMeasurents(int numOfMeasurents) { this.numOfMeasurements = numOfMeasurents; }

    public Long getId() { return activityId; }

    public void setId(Long id) { this.activityId = id; }

}
