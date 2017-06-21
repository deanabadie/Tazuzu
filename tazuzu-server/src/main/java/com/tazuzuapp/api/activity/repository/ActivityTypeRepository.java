package com.tazuzuapp.api.activity.repository;

import com.tazuzuapp.api.activity.domain.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {

    Long findActivityIdByName(String activityName);

}
