package com.tazuzuapp.api.activity.repository;

import com.tazuzuapp.api.activity.domain.TestDistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDistanceRepository extends JpaRepository<TestDistance, Long> {
    List<TestDistance> findAll();

}
