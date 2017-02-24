package com.tazuzu.activity.repository;

import com.tazuzu.activity.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAll();
    Activity findByActivityName(String activityName);
}