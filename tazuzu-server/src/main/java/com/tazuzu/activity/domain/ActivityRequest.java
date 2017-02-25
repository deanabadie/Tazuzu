package com.tazuzu.activity.domain;

import javax.validation.constraints.NotNull;

/**
 * Created by nofarb on 25-Feb-17.
 */
public class ActivityRequest {
    @NotNull
    private String activityName;

    private Long activityTypeId;

    private int numOfMeasurements;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Long getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Long activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public int getNumOfMeasurements() {
        return numOfMeasurements;
    }

    public void setNumOfMeasurements(int numOfMeasurements) {
        this.numOfMeasurements = numOfMeasurements;
    }
}
