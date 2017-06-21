package com.tazuzuapp.api.activity.repository;

import com.tazuzuapp.api.activity.domain.ActivityInstanceMeasurement;
import com.tazuzuapp.api.user.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface ActivityInstanceMeasurementRepository extends JpaRepository<ActivityInstanceMeasurement, Long> {
    List<ActivityInstanceMeasurement> findByStudentAndActivityInstanceActivityDateBefore(Student s, Date now);
    List<ActivityInstanceMeasurement> findByStudentAndActivityInstanceActivityDateAfter(Student s, Date now);

}
