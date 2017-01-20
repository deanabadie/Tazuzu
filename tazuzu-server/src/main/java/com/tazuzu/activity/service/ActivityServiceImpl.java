package com.tazuzu.activity.service;

import com.tazuzu.activity.domain.Activity;
import com.tazuzu.activity.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class ActivityServiceImpl {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

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
