package com.tazuzu.services.activity.repository;

import com.tazuzu.services.activity.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nofarb on 19-Jan-17.
 */
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAll();
}
