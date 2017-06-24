package com.tazuzuapp.api.activity.domain;

import javax.validation.constraints.NotNull;

public class ActivityInstanceMeasurementRequest {

    @NotNull
    private Double result;

    public Double getResult() {
        return result;
    }

    public ActivityInstanceMeasurementRequest setResult(Double result) {
        this.result = result;
        return this;
    }
}
