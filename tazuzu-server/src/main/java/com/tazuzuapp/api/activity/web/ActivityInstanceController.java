package com.tazuzuapp.api.activity.web;

import com.tazuzuapp.api.activity.domain.ActivityInstance;
import com.tazuzuapp.api.activity.domain.ActivityInstanceRequest;
import com.tazuzuapp.api.activity.service.ActivityInstanceService;
import com.tazuzuapp.api.user.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/activityInstances")
@SuppressWarnings("unused")
public class ActivityInstanceController {

    private final ActivityInstanceService service;

    @Autowired
    public ActivityInstanceController(ActivityInstanceService activityInstanceService) { this.service = activityInstanceService; }

    @PostMapping
    public ResponseEntity<ActivityInstance> createActivityInstance(@RequestBody ActivityInstanceRequest activityInstanceRequest) {
        ActivityInstance activityInstance = service.createActivityInstance(activityInstanceRequest);
        return new ResponseEntity<>(activityInstance, HttpStatus.CREATED);
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



}
