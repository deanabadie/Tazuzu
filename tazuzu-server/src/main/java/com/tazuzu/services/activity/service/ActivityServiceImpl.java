package com.tazuzu.services.activity.service;

import com.tazuzu.services.activity.domain.Activity;
import com.tazuzu.services.activity.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nofarb on 19-Jan-17.
 */
@Service
public class ActivityServiceImpl implements ActivityService{

    @Autowired
    ActivityRepository activityRepository;

    public Activity getActivity(long userId) {
        return activityRepository.getOne(userId);
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Transactional
    public Activity createActivity(Activity user) {
        return activityRepository.save(user);
    }

    @Transactional
    public void updateActivity(Activity user) {
        activityRepository.save(user);
    }

    @Transactional
    public void deleteActivity(Long userId) {
        activityRepository.delete(userId);
    }
}
