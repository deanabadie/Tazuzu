package com.tazuzuapp.api.activity.web;

import com.tazuzuapp.api.activity.domain.ActivityInstance;
import com.tazuzuapp.api.activity.domain.ActivityInstanceMeasurement;
import com.tazuzuapp.api.activity.domain.ActivityInstanceRequest;
import com.tazuzuapp.api.activity.domain.PayloadResponse;
import com.tazuzuapp.api.activity.repository.ActivityInstanceRepository;
import com.tazuzuapp.api.activity.repository.ActivityTypeRepository;
import com.tazuzuapp.api.activity.service.ActivityInstanceService;
import com.tazuzuapp.api.user.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.awt.geom.Path2D;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/activities")
@SuppressWarnings("unused")
public class ActivityController {

    private final ActivityInstanceService service;

    private final ActivityTypeRepository activityTypeRepository;

    private final ActivityInstanceRepository activityInstanceRepository;

    @Autowired
    public ActivityController(
            ActivityInstanceService activityInstanceService,
            ActivityTypeRepository activityTypeRepository,
            ActivityInstanceRepository activityInstanceRepository
    ) {
        this.service = activityInstanceService;
        this.activityTypeRepository = activityTypeRepository;
        this.activityInstanceRepository = activityInstanceRepository;
    }

    @GetMapping(value = "/payload")
    public ResponseEntity<PayloadResponse> Payload() {
        PayloadResponse response = new PayloadResponse(activityTypeRepository, activityInstanceRepository);
        return new ResponseEntity<>(response, HttpStatus.OK);
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

    @PutMapping(value = "/{id}")
    public ResponseEntity<ActivityInstance> updateActivityInstance(@PathVariable Long id, @RequestBody ActivityInstanceRequest activityInstanceRequest) {
        if ( !service.exists(id) ) {
            throw new EntityNotFoundException("Could not find test distance with given id: " + id);
        }

        ActivityInstance activityInstance = service.updateActivityInstance(id, activityInstanceRequest);
        return new ResponseEntity<>(activityInstance, HttpStatus.OK);
    }

    @GetMapping
    public List<ActivityInstance> getActivityInstance() {
        return service.getAllActivityInstance();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ActivityInstance> getEntity(@PathVariable Long id) {
        ActivityInstance activityInstance = service.getActivityInstance(id);

        if ( activityInstance == null ) {
            throw new EntityNotFoundException("Could not find student with the given id (" + id + ")");
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

}
