package com.tazuzuapp.api.activity.repository;

import com.tazuzuapp.api.activity.domain.ActivityInstance;
import com.tazuzuapp.api.user.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ActivityInstanceRepository extends JpaRepository<ActivityInstance, Long> {
    ActivityInstance findByActivityDateBefore(LocalDateTime now);
}
