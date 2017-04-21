package com.tazuzuapp.api.activity.domain;

import com.tazuzuapp.api.general.domain.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@SuppressWarnings("unused")
public class Activity extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long activityId;

    @NotNull
    private String activityName;

    @NotEmpty
    private int numOfMeasurements;

    @NotNull
    private Long measurementTypeId;

    public Activity (){}

    public String getActivityName() { return activityName; }

    public void setActivityName(String activityName) { this.activityName = activityName; }

    public Long getId() { return activityId; }

    public void setId(Long id) { this.activityId = id; }

    public void setNumOfMeasurements(int numOfMeasurements) {
        this.numOfMeasurements = numOfMeasurements;
    }

    public int getNumOfMeasurements() {
        return numOfMeasurements;
    }
}
