package com.tazuzuapp.api.activity.service;

import com.tazuzuapp.api.activity.domain.MeasurementType;
import com.tazuzuapp.api.activity.repository.ActivityRepository;
import com.tazuzuapp.api.activity.repository.MeasurementTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by deana on 11/03/2017.
 */
@Service
public class MeasurementTypeService {

    private final MeasurementTypeRepository measurementTypeRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public MeasurementTypeService(MeasurementTypeRepository measurementTypeRepository, ActivityRepository activityRepository) {
        this.measurementTypeRepository = measurementTypeRepository;
        this.activityRepository = activityRepository;
    }

    public MeasurementType getMeasurementType(Long measurementTypeId) { return measurementTypeRepository.findOne(measurementTypeId); }

    public List<MeasurementType> getAllMeasurementTypes() { return measurementTypeRepository.findAll(); }

}
