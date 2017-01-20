package com.tazuzu.activity.service;

import com.tazuzu.activity.domain.Activity;
import com.tazuzu.activity.repository.ActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

}
