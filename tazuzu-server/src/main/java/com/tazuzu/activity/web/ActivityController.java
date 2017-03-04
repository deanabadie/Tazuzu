package com.tazuzu.activity.web;

import com.tazuzu.activity.domain.Activity;
import com.tazuzu.activity.domain.ActivityRequest;
import com.tazuzu.activity.service.ActivityServiceImpl;
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

    private final ActivityServiceImpl service;

    @Autowired
    public ActivityController(ActivityServiceImpl activityService) {
        this.service = activityService;
    }

    @PostMapping
    public ResponseEntity<?> createActivity(@RequestBody ActivityRequest activityRequest) {
        Activity activity = service.createActivity(activityRequest);
        return new ResponseEntity<>(activity, HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Activity> getEntity(@PathVariable Long id) {
        Activity a = service.getActivity(id);

        if ( a == null ) {
            throw new EntityNotFoundException("Could not find activity with the given id (" + id + ")");
        }

        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @GetMapping
    public List<Activity> getActivities() {
        return service.getAllActivities();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long id, @RequestBody ActivityRequest activityRequest) {
        if ( !service.exists(id) ) {
            throw new EntityNotFoundException("Could not find activity with given id " + id);
        }

        Activity activity = service.updateActivity(id, activityRequest);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

}
