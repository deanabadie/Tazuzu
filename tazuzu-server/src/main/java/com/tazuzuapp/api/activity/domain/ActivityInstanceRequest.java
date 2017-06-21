package com.tazuzuapp.api.activity.domain;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
public class ActivityInstanceRequest {

    @NotNull
    private Long activityTypeId;

    @NotNull
    private Date time;

    @NotNull
    private boolean isMandatory;

    private Long classId;

    private Long activityInstanceMeasurementId;

    private List<Long> studentIds;

    public Long getActivityTypeId() {
        return activityTypeId;
    }

    public ActivityInstanceRequest setActivityTypeId(Long activityTypeId) {
        this.activityTypeId = activityTypeId;
        return this;
    }

    public Date getTime() {
        return time;
    }

    public ActivityInstanceRequest setTime(Date time) {
        this.time = time;
        return this;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public ActivityInstanceRequest setMandatory(boolean mandatory) {
        isMandatory = mandatory;
        return this;
    }

    public Long getClassId() {
        return classId;
    }

    public ActivityInstanceRequest setClassId(Long classId) {
        this.classId = classId;
        return this;
    }

    public Long getActivityInstanceMeasurementId() {
        return activityInstanceMeasurementId;
    }

    public ActivityInstanceRequest setActivityInstanceMeasurementId(Long activityInstanceMeasurementId) {
        this.activityInstanceMeasurementId = activityInstanceMeasurementId;
        return this;
    }

    public List<Long> getStudentIds() {
        return studentIds;
    }

    public ActivityInstanceRequest setStudentIds(List<Long> studentIds) {
        this.studentIds = studentIds;
        return this;
    }
}

