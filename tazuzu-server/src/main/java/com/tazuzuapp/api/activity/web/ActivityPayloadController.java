package com.tazuzuapp.api.activity.web;

import com.tazuzuapp.api.activity.domain.ActivityInstance;
import com.tazuzuapp.api.activity.domain.ActivityType;
import com.tazuzuapp.api.activity.repository.ActivityInstanceRepository;
import com.tazuzuapp.api.activity.repository.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/activities")
@SuppressWarnings("unused")
public class ActivityPayloadController {

    private final ActivityInstanceRepository activityInstanceRepository;
    private final ActivityTypeRepository activityTypeRepository;

    @Autowired
    public ActivityPayloadController(ActivityInstanceRepository activityInstanceRepository, ActivityTypeRepository activityTypeRepository) {
        this.activityInstanceRepository = activityInstanceRepository;
        this.activityTypeRepository = activityTypeRepository;
    }

    @GetMapping(value = "/payload")
    public ResponseEntity<PayloadResponse> Payload() {
        PayloadResponse response = new PayloadResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private class PayloadResponse{
        List<ActivityType> activityTypes;
        List<ActivityInstance>  activityInstances;

        public PayloadResponse() {
            this.activityTypes = activityTypeRepository.findAll();
            this.activityInstances = activityInstanceRepository.findAll();
        }
    }

}


