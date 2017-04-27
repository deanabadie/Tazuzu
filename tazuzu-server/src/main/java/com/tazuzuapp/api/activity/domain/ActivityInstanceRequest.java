package com.tazuzuapp.api.activity.domain;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class ActivityInstanceRequest {
    
    @NotNull
    private Long activityTypeId;

    @NotNull
//    @Size(min = 1, max = 3)
    private Long numOfMeasurements;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date activityDate;

    @NotNull
    private boolean isMandatory;

    public Long getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Long activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public Long getNumOfMeasurements() {
        return numOfMeasurements;
    }

    public void setNumOfMeasurements(Long numOfMeasurements) {
        this.numOfMeasurements = numOfMeasurements;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }
}

