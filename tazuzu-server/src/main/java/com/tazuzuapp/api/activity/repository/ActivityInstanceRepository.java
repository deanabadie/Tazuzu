package com.tazuzuapp.api.activity.repository;

import com.tazuzuapp.api.activity.domain.ActivityInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ActivityInstanceRepository extends JpaRepository<ActivityInstance, Long> {
    List<ActivityInstance> findByActivityDateAfter(LocalDateTime now);
    List<ActivityInstance> findByActivityDateBefore(LocalDateTime now);
}
