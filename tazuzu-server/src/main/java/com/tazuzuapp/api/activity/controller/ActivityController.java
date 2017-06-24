package com.tazuzuapp.api.activity.controller;

import com.tazuzuapp.api.ApplicationProperties;
import com.tazuzuapp.api.activity.domain.*;
import com.tazuzuapp.api.activity.repository.ActivityInstanceMeasurementRepository;
import com.tazuzuapp.api.activity.service.ActivityInstanceService;
import com.tazuzuapp.api.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/activities")
@SuppressWarnings("unused")
public class ActivityController {

    private final ActivityInstanceService service;

    private final ActivityInstanceMeasurementRepository measurementRepository;

    private final ApplicationProperties applicationProperties;

    @Autowired
    public ActivityController(
            ActivityInstanceService activityInstanceService,
            ApplicationProperties applicationProperties,
            ActivityInstanceMeasurementRepository activityInstanceMeasurementRepository
    ) {
        this.service = activityInstanceService;
        this.applicationProperties = applicationProperties;
        this.measurementRepository = activityInstanceMeasurementRepository;
    }

    @PostMapping(value = "")
    public ResponseEntity<ActivityInstance> createActivityInstance(@RequestBody ActivityInstanceRequest activityInstanceRequest, @RequestAttribute("user") User requestUser) {
        try {
            ActivityInstance activityInstance = service.createActivityInstance(activityInstanceRequest, requestUser);
            return new ResponseEntity<>(activityInstance, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ActivityInstance> getEntity(@PathVariable Long id) {
        ActivityInstance activityInstance = service.getActivityInstance(id);

        if ( activityInstance == null ) {
            throw new EntityNotFoundException("Could not find activity with the given id (" + id + ")");
        }

        return new ResponseEntity<>(activityInstance, HttpStatus.OK);
    }

    @GetMapping(value = "/students/{studentId}")
    public ResponseEntity<Map<String, List<ActivityInstanceMeasurement>>> getStudentActivities(@RequestAttribute("user") User requestUser, @PathVariable Long studentId) {
        if ( !requestUser.getId().equals(studentId) ) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Map<String, List<ActivityInstanceMeasurement>> activities = new HashMap<>(2);
        activities.put("past", service.getStudentPastMeasurements(requestUser.getId()));
        activities.put("pending", service.getStudentPendingMeasurements(requestUser.getId()));

        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @GetMapping(value = "/teachers/{studentId}")
    public ResponseEntity<Map<String, List<ActivityInstance>>> getTeacherActivities(@RequestAttribute("user") User requestUser, @PathVariable Long studentId) {
        if ( !requestUser.getId().equals(studentId) ) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Map<String, List<ActivityInstance>> activities = new HashMap<>(2);
        activities.put("past", service.getTeacherPastActivities(requestUser.getId()));
        activities.put("pending", service.getTeacherPendingActivities(requestUser.getId()));

        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @GetMapping(value = "/instances/{instanceId}/measurements")
    public ResponseEntity<List<ActivityInstanceMeasurement>> getActivityInstanceResults(@PathVariable("instanceId") Long instanceId) {
        return new ResponseEntity<>(service.getMeasurementsByInstanceId(instanceId), HttpStatus.OK);
    }

    private static class UpdateValueRequest {
        private Double value;

        public Double getValue() {
            return value;
        }

        public UpdateValueRequest setValue(Double value) {
            this.value = value;
            return this;
        }
    }

    @PatchMapping(value = "/measurements/{id}/result")
    public ResponseEntity<ActivityInstanceMeasurement> updateMeasurementResult(@PathVariable Long id, @RequestBody UpdateValueRequest request) {
        ActivityInstanceMeasurement measurement = measurementRepository.findOne(id);

        if ( measurement == null) {
            throw new EntityNotFoundException("Could not find measurement with given id: " + id);
        }

        switch(measurement.getActivityInstance().getActivityType().getMeasurementTypeId()) {
            case DISTANCE:
                    measurement.setResultDistance(request.getValue());
                break;
            case TIME:
                    measurement.setResultTimeSeconds(request.getValue().longValue());
                break;
            case QUANTITY:
                    measurement.setResultQuantity(request.getValue().intValue());
                break;
        }

        measurementRepository.save(measurement);

        return new ResponseEntity<>(measurement, HttpStatus.OK);
    }

    @PatchMapping(value = "/measurements/{id}/grade")
    public ResponseEntity<ActivityInstanceMeasurement> updateMeasurementGrade(@PathVariable Long id, @RequestBody() UpdateValueRequest request) {
        ActivityInstanceMeasurement measurement = measurementRepository.findOne(id);

        if ( measurement == null) {
            throw new EntityNotFoundException("Could not find measurement with given id: " + id);
        }
        measurement.setGrade(request.getValue());
        measurementRepository.save(measurement);

        return new ResponseEntity<>(measurement, HttpStatus.OK);
    }

    @GetMapping(value = "/participation-approval")
    public ModelAndView updateActivityParticipationApproval(@RequestParam("token") String participationToken) {

        ActivityInstanceMeasurement measurement = measurementRepository
                .findOneByParticipationApprovalToken(participationToken);

        if ( measurement != null ) {
            measurement.setParticipationApproval(true);
            measurement.setParticipationApprovalToken(null);
            measurementRepository.save(measurement);
        }

        String sb = "redirect:" +
                this.applicationProperties.getApplicationUrl() +
                "/students/activities/list?confirmation=ok";

        return new ModelAndView(sb);
    }
}
