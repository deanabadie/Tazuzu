package com.tazuzuapp.api.activity.domain;

import com.tazuzuapp.api.activity.repository.ActivityInstanceRepository;
import com.tazuzuapp.api.activity.repository.ActivityTypeRepository;

import java.util.List;

public class PayloadResponse {
    private List<ActivityType> activityTypes;
    private List<ActivityInstance> activityInstances;

    public PayloadResponse(ActivityTypeRepository activityTypeRepository, ActivityInstanceRepository activityInstanceRepository) {
        this.activityTypes = activityTypeRepository.findAll();
        this.activityInstances = activityInstanceRepository.findAll();
    }

    public List<ActivityType> getActivityTypes() {
        return activityTypes;
    }

    public void setActivityTypes(List<ActivityType> activityTypes) {
        this.activityTypes = activityTypes;
    }

    public List<ActivityInstance> getActivityInstances() {
        return activityInstances;
    }

    public void setActivityInstances(List<ActivityInstance> activityInstances) {
        this.activityInstances = activityInstances;
    }
}