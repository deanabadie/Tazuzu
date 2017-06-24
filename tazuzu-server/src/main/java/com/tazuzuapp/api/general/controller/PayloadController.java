package com.tazuzuapp.api.general.controller;

import com.tazuzuapp.api.activity.domain.ActivityType;
import com.tazuzuapp.api.activity.domain.PayloadResponse;
import com.tazuzuapp.api.activity.repository.ActivityTypeRepository;
import com.tazuzuapp.api.organization.domain.Class;
import com.tazuzuapp.api.organization.domain.School;
import com.tazuzuapp.api.organization.repository.ClassRepository;
import com.tazuzuapp.api.organization.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/payload")
public class PayloadController {

    private final SchoolRepository schoolRepository;

    private final ClassRepository classRepository;

    private final ActivityTypeRepository activityTypeRepository;

    @Autowired
    public PayloadController(SchoolRepository schoolRepository, ClassRepository classRepository, ActivityTypeRepository activityTypeRepository) {
        this.schoolRepository = schoolRepository;
        this.classRepository = classRepository;
        this.activityTypeRepository = activityTypeRepository;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayloadResponse> getPayload() {
        PayloadResponse payloadResponse = new PayloadResponse();

        //Schools
        List<School> schools = schoolRepository.findAll();
        payloadResponse.setSchools(schools);

        //Classes
        Map<Long, List<Class>> classes = new HashMap<>();
        for(School s : schools) {
            List<Class> schoolClasses = classRepository.findBySchoolId(s.getId());
            classes.put(s.getId(), schoolClasses);
        }
        payloadResponse.setClasses(classes);

        List<ActivityType> activityTypes = activityTypeRepository.findAll();
        payloadResponse.setActivityTypes(activityTypes);

        return new ResponseEntity<>(payloadResponse, HttpStatus.OK);
    }

}
