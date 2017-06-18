package com.tazuzuapp.api.activity.controller;

import com.tazuzuapp.api.activity.domain.*;
import com.tazuzuapp.api.activity.service.ActivityInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/activities")
@SuppressWarnings("unused")
public class ActivityController {

    private final ActivityInstanceService service;

    @Autowired
    public ActivityController(
            ActivityInstanceService activityInstanceService
    ) {
        this.service = activityInstanceService;
    }

    @PostMapping(value = "")
    public ResponseEntity<ActivityInstance> createActivityInstance(@RequestBody ActivityInstanceRequest activityInstanceRequest) {
        try {
            ActivityInstance activityInstance = service.createActivityInstance(activityInstanceRequest);
            return new ResponseEntity<>(activityInstance, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<ActivityInstance> getActivityInstance() {
        return service.getAllActivityInstance();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ActivityInstance> getEntity(@PathVariable Long id) {
        ActivityInstance activityInstance = service.getActivityInstance(id);

        if ( activityInstance == null ) {
            throw new EntityNotFoundException("Could not find activity with the given id (" + id + ")");
        }

        return new ResponseEntity<>(activityInstance, HttpStatus.OK);
    }

    @GetMapping(value = "/students/{id}/activities/pending")
    public ResponseEntity<List<ActivityInstanceMeasurement>> getPendingActivities(@PathVariable Long id) {
        List<ActivityInstanceMeasurement> activityInstanceMeasurements = service.getPendingMeasurements(id);
        return new ResponseEntity<>(activityInstanceMeasurements, HttpStatus.OK);
    }

    @GetMapping(value = "/students/{id}/activities/past")
    public ResponseEntity<List<ActivityInstanceMeasurement>> getPastMeasurements(@PathVariable Long id) {
        List<ActivityInstanceMeasurement> activityInstancesMeasurements = service.getPastMeasurements(id);
        return new ResponseEntity<>(activityInstancesMeasurements, HttpStatus.OK);
    }

    @PutMapping(value = "/measurements/{id}")
    public ResponseEntity<ActivityInstanceMeasurement> updateActivityInstanceMeasurement(@PathVariable Long id, @RequestBody ActivityInstanceMeasurementRequest activityInstanceMeasurementRequest) {
        if ( !service.exists(id) ) {
            throw new EntityNotFoundException("Could not find measurement with given id: " + id);
        }

        ActivityInstanceMeasurement activityInstanceMeasurement = null;
        try {
            activityInstanceMeasurement = service.updateActivityInstanceMeasurement(id, activityInstanceMeasurementRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(activityInstanceMeasurement, HttpStatus.OK);
    }
}
