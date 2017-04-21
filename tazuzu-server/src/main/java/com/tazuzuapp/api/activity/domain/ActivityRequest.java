package com.tazuzuapp.api.activity.domain;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ActivityRequest {

    @NotNull
    private String activityName;

    @NotEmpty
    private int numOfMeasurements;

    @NotNull
    private Long measurementTypeId;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getNumOfMeasurements() {
        return numOfMeasurements;
    }

    public void setNumOfMeasurements(int numOfMeasurements) {
        this.numOfMeasurements = numOfMeasurements;
    }

    public Long getMeasurementTypeId() {
        return measurementTypeId;
    }

    public void setMeasurementTypeId(Long measurementTypeId) {
        this.measurementTypeId = measurementTypeId;
    }
}
