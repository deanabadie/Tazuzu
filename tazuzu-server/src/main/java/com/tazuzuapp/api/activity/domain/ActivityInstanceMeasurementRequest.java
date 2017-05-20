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
    private Duration resultTime;

    @NotNull
    private Long activityInstanceId;

    @NotNull
    private Long studentId;

    public Double getGrade() { return grade; }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Double getResultDistance() {
        return resultDistance;
    }

    public void setResultDistance(Double resultDistance) {
        this.resultDistance = resultDistance;
    }

    public Integer getResultQuantity() {
        return resultQuantity;
    }

    public void setResultQuantity(Integer resultQuantity) {
        this.resultQuantity = resultQuantity;
    }

    public Duration getResultTime() { return resultTime; }

    public void setResultTime(Duration resultTime) { this.resultTime = resultTime; }

    public Long getActivityInstanceId() {
        return activityInstanceId;
    }

    public void setActivityInstanceId(Long activityInstanceId) {
        this.activityInstanceId = activityInstanceId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
