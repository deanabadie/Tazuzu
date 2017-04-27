package com.tazuzuapp.api.activity.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class ActivityInstance {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long activityInstanceId;

    @NotNull
    @ManyToOne
    ActivityType activityType;

    @NotNull
    private Long numOfMeasurements;

    @NotNull
    private boolean isMandatory;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date activityDate;

    public ActivityInstance(ActivityInstanceRequest activityInstanceRequest) {
        activityDate = activityInstanceRequest.getActivityDate();
        numOfMeasurements = activityInstanceRequest.getNumOfMeasurements();
        isMandatory = activityInstanceRequest.isMandatory();
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public Long getNumOfMeasurements() {
        return numOfMeasurements;
    }

    public void setNumOfMeasurements(Long numOfMeasurements) {
        this.numOfMeasurements = numOfMeasurements;
    }
}
