package com.tazuzuapp.api.activity.domain;

import com.tazuzuapp.api.user.domain.Student;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

public class ActivityInstanceRequest {
    
    @NotNull
    private Long activityTypeId;

    @NotNull
    private Long numOfMeasurements;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date activityDate;

    @NotNull
    private boolean isMandatory;

    private Long classId;

    private List<Long> studentIdList;

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

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public List<Long> getStudentIdList() {
        return studentIdList;
    }

    public void setStudentIdList(List<Long> studentIdList) {
        this.studentIdList = studentIdList;
    }
}

