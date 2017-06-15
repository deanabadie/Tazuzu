package com.tazuzuapp.api.activity.domain;

import com.tazuzuapp.api.organization.domain.Class;
import com.tazuzuapp.api.organization.domain.School;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class PayloadResponse {
    private List<ActivityType> activityTypes;
    private List<School> schools;
    private Map<Long, List<Class>> classes;

    public List<ActivityType> getActivityTypes() {
        return activityTypes;
    }

    public void setActivityTypes(List<ActivityType> activityTypes) {
        this.activityTypes = activityTypes;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    public Map<Long, List<Class>> getClasses() {
        return classes;
    }

    public void setClasses(Map<Long, List<Class>> classes) {
        this.classes = classes;
    }
}