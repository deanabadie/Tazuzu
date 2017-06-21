package com.tazuzuapp.api.activity.domain;

import com.tazuzuapp.api.general.domain.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@SuppressWarnings("unused")
public class ActivityType extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private MeasurementType measurementTypeId;

    private int numOfMeasurements;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public MeasurementType getMeasurementTypeId() {
        return measurementTypeId;
    }

    public void setMeasurementTypeId(MeasurementType measurementTypeId) {
        this.measurementTypeId = measurementTypeId;
    }

    public int getNumOfMeasurements() {
        return numOfMeasurements;
    }

    public void setNumOfMeasurements(int numOfMeasurements) {
        this.numOfMeasurements = numOfMeasurements;
    }
}
