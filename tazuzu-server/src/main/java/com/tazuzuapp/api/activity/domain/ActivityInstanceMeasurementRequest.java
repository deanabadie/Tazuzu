package com.tazuzuapp.api.activity.domain;

import javax.validation.constraints.NotNull;
import java.time.Duration;

public class ActivityInstanceMeasurementRequest {

    @NotNull
    private Double grade;

    @NotNull
    private Double resultDistance;

    @NotNull
    private Integer resultQuantity;

    @NotNull
    private Long resultTime;

    @NotNull
    private Long activityInstanceId;

    @NotNull
    private Long studentId;

    public Double getGrade() {
        return grade;
    }

    public ActivityInstanceMeasurementRequest setGrade(Double grade) {
        this.grade = grade;
        return this;
    }

    public Double getResultDistance() {
        return resultDistance;
    }

    public ActivityInstanceMeasurementRequest setResultDistance(Double resultDistance) {
        this.resultDistance = resultDistance;
        return this;
    }

    public Integer getResultQuantity() {
        return resultQuantity;
    }

    public ActivityInstanceMeasurementRequest setResultQuantity(Integer resultQuantity) {
        this.resultQuantity = resultQuantity;
        return this;
    }

    public Long getResultTime() {
        return resultTime;
    }

    public ActivityInstanceMeasurementRequest setResultTime(Long resultTime) {
        this.resultTime = resultTime;
        return this;
    }

    public Long getActivityInstanceId() {
        return activityInstanceId;
    }

    public ActivityInstanceMeasurementRequest setActivityInstanceId(Long activityInstanceId) {
        this.activityInstanceId = activityInstanceId;
        return this;
    }

    public Long getStudentId() {
        return studentId;
    }

    public ActivityInstanceMeasurementRequest setStudentId(Long studentId) {
        this.studentId = studentId;
        return this;
    }
}
