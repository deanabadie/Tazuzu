package com.tazuzuapp.api.activity.service;

import com.tazuzuapp.api.activity.domain.Activity;
import com.tazuzuapp.api.activity.domain.ActivityRequest;
import com.tazuzuapp.api.activity.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class ActivityServiceImpl {

    /*private final ActivityRepository activityRepository;

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
    }*/

    private final ActivityRepository activityRepository;

    /**
     * Auto wired is injecting a service representing the required type
     * Because we declared StudentRepository as a @Repository (which is just another type of @Component)
     * We can inject every service/repository/component into other Spring components by using the autowired annotation
     * You just declare a new constructor with all the types that you want to use and Spring is doing it for you...
     *
     * The initial example you did was declaring Autowired on a property and not on the constructor - which is bad practice
     * Do not do it :)
     */
    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository) { this.activityRepository = activityRepository; }

    public Activity getActivity(Long activityId) { return activityRepository.findOne(activityId); }

    public List<Activity> getAllActivities() { return activityRepository.findAll(); }

    @Transactional
    public Activity createActivity(ActivityRequest activityRequest) {

        Activity newActivity = new Activity();
        newActivity.setActivityName(activityRequest.getActivityName());
        newActivity.setActivityTypeId(activityRequest.getActivityTypeId());
        newActivity.setNumOfMeasurements(activityRequest.getNumOfMeasurements());
        return activityRepository.save(newActivity);

    }

    @Transactional
    public Activity updateActivity(Long id, ActivityRequest activityRequest) {

        Activity originalActivity = activityRepository.findOne(id);

        originalActivity.setActivityName(activityRequest.getActivityName());
        originalActivity.setActivityTypeId(activityRequest.getActivityTypeId());
        originalActivity.setNumOfMeasurements(activityRequest.getNumOfMeasurements());
        return activityRepository.save(originalActivity);
    }

    public Boolean exists(Long activityId) { return activityRepository.exists(activityId); }

    public void deleteActivity(Long activityId) { activityRepository.delete(activityId);}
}
