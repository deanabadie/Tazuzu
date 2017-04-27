package com.tazuzuapp.api.activity.service;

import com.tazuzuapp.api.activity.domain.ActivityInstance;
import com.tazuzuapp.api.activity.domain.ActivityInstanceRequest;
import com.tazuzuapp.api.activity.repository.ActivityInstanceRepository;
import com.tazuzuapp.api.activity.repository.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityInstanceService {
    private final ActivityTypeRepository activityTypeRepository;
    private final ActivityInstanceRepository activityInstanceRepository;

    @Autowired
    public ActivityInstanceService(ActivityTypeRepository activityTypeRepository, ActivityInstanceRepository activityInstanceRepository) {
        this.activityTypeRepository = activityTypeRepository;
        this.activityInstanceRepository = activityInstanceRepository;
    }

    public ActivityInstance createActivityInstance(ActivityInstanceRequest activityInstanceRequest) {
        ActivityInstance activityInstance = new ActivityInstance(activityInstanceRequest);
        activityInstance.setActivityType(activityTypeRepository.findOne(activityInstanceRequest.getActivityTypeId()));
        activityInstanceRepository.save(activityInstance);
        return activityInstance;
    }

    public boolean exists(Long id) {
        return activityInstanceRepository.exists(id);
    }

    public ActivityInstance updateActivityInstance(Long id, ActivityInstanceRequest activityInstanceRequest) {
        ActivityInstance activityInstance = activityInstanceRepository.findOne(id);
        activityInstance.setActivityType(activityTypeRepository.findOne(activityInstanceRequest.getActivityTypeId()));
        activityInstance.setActivityDate(activityInstanceRequest.getActivityDate());
        activityInstance.setNumOfMeasurements(activityInstanceRequest.getNumOfMeasurements());
        activityInstanceRepository.save(activityInstance);
        return activityInstance;
    }

    public List<ActivityInstance> getAllActivityInstance() {
        return activityInstanceRepository.findAll();
    }

    public ActivityInstance getActivityInstance(Long id) {
        return activityInstanceRepository.findOne(id);
    }
}
