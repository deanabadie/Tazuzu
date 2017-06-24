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
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/activities")
@SuppressWarnings("unused")
public class ActivityController {

    private final ActivityInstanceService service;

    private final ActivityInstanceMeasurementRepository activityInstanceMeasurementRepository;

    private final ApplicationProperties applicationProperties;

    @Autowired
    public ActivityController(
            ActivityInstanceService activityInstanceService,
            ApplicationProperties applicationProperties,
            ActivityInstanceMeasurementRepository activityInstanceMeasurementRepository
    ) {
        this.service = activityInstanceService;
        this.applicationProperties = applicationProperties;
        this.activityInstanceMeasurementRepository = activityInstanceMeasurementRepository;
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

    @GetMapping(value = "/participation-approval")
    public ModelAndView updateActivityParticipationApproval(@RequestParam("token") String participationToken) {

        ActivityInstanceMeasurement measurement = activityInstanceMeasurementRepository
                .findOneByParticipationApprovalToken(participationToken);

        if ( measurement != null ) {
            measurement.setParticipationApproval(true);
            measurement.setParticipationApprovalToken(null);
            activityInstanceMeasurementRepository.save(measurement);
        }

        String sb = "redirect:" +
                this.applicationProperties.getApplicationUrl() +
                "/students/activities/list?confirmation=ok";

        return new ModelAndView(sb);
    }
}
