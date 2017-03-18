package com.tazuzuapp.api.activity.domain;

/**
 * Created by deana on 11/03/2017.
 */

import com.tazuzuapp.api.general.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class MeasurementType extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long measurementTypeId;

    private String description;

    @NotNull
    private long LastEditedBy;

    public long getMeasurementTypeId() {
        return measurementTypeId;
    }

    public void setMeasurementTypeId(long measurementTypeId) {
        this.measurementTypeId = measurementTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getLastEditedBy() {
        return LastEditedBy;
    }

    public void setLastEditedBy(long lastEditedBy) {
        LastEditedBy = lastEditedBy;
    }


}
