package com.tazuzuapp.api.activity.repository;

import com.tazuzuapp.api.activity.domain.ActivityInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityInstanceRepository extends JpaRepository<ActivityInstance, Long> {

}
