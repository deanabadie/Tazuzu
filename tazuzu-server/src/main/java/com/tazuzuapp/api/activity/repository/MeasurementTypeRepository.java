package com.tazuzuapp.api.activity.repository;

import com.tazuzuapp.api.activity.domain.MeasurementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by deana on 11/03/2017.
 */
@Repository
public interface MeasurementTypeRepository extends JpaRepository <MeasurementType, Long> {
    List<MeasurementType> findAll();
}
