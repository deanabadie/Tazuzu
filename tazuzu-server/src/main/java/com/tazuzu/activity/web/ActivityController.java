package com.tazuzu.activity.web;

import com.tazuzu.activity.domain.Activity;
import com.tazuzu.activity.service.ActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activities")
@SuppressWarnings("unused")
public class ActivityController {

    private final ActivityServiceImpl activityService;

    @Autowired
    public ActivityController(ActivityServiceImpl activityService) {
        this.activityService = activityService;
    }

    @PostMapping
    public ResponseEntity<?> createActivity(@RequestBody Activity activity) {
        activity = activityService.createActivity(activity);

        return new ResponseEntity<>(activity, HttpStatus.CREATED);
    }

}
