package com.tazuzuapp.api.activity.domain;

import com.tazuzuapp.api.general.domain.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@SuppressWarnings("unused")
public class ActivityType extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long activityId;

    @NotNull
    private String activityName;

    @NotNull
    private MeasurementType measurementTypeId;

    private int numOfMeasurements;

    public Long getId() { return activityId; }

    public void setId(Long id) { this.activityId = id; }

    public String getActivityName() { return activityName; }

    public void setActivityName(String activityName) { this.activityName = activityName; }

    public MeasurementType getMeasurementTypeId() {
        return measurementTypeId;
    }

    public void setMeasurementTypeId(MeasurementType measurementTypeId) {
        this.measurementTypeId = measurementTypeId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public int getNumOfMeasurements() {
        return numOfMeasurements;
    }

    public void setNumOfMeasurements(int numOfMeasurements) {
        this.numOfMeasurements = numOfMeasurements;
    }
}
