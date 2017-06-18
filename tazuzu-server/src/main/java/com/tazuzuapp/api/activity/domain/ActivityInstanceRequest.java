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

    public void setActivityTypeId(Long activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public Long getActivityInstanceMeasurementId() {
        return activityInstanceMeasurementId;
    }

    public void setActivityInstanceMeasurementId(Long activityInstanceMeasurementId) {
        this.activityInstanceMeasurementId = activityInstanceMeasurementId;
    }

    public List<Long> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Long> studentIds) {
        this.studentIds = studentIds;
    }
}

