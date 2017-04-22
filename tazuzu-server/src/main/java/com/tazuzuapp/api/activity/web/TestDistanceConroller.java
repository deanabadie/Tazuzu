package com.tazuzuapp.api.activity.web;

import com.tazuzuapp.api.activity.domain.TestDistance;
import com.tazuzuapp.api.activity.domain.TestDistanceRequest;
import com.tazuzuapp.api.activity.service.TestDistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/testDistance")

public class TestDistanceConroller {
    private final TestDistanceService service;

    @Autowired
    public TestDistanceConroller(TestDistanceService testDistanceService) { this.service = testDistanceService; }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TestDistance> getEntity(@PathVariable Long id) {
        TestDistance testDistance = service.getTestDistance(id);

        if ( testDistance == null ) {
            throw new EntityNotFoundException("Could not find distance test with the given id (" + id + ")");
        }

        return new ResponseEntity<>(testDistance, HttpStatus.OK);
    }

    @GetMapping
    public List<TestDistance> getMeasurementTypes() {
        return service.getAllTestDistance();
    }

    @PostMapping
    public ResponseEntity<TestDistance> createTestDistance(@RequestBody TestDistanceRequest testDistanceRequest) {
        TestDistance test = service.createTestDistance(testDistanceRequest);
        return new ResponseEntity<>(test, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TestDistance> updateTeacher(@PathVariable Long id, @RequestBody TestDistanceRequest testDistanceRequest) {
        if ( !service.exists(id) ) {
            throw new EntityNotFoundException("Could not find test distance with given id: " + id);
        }

        TestDistance testDistance = service.updateTestDistance(id, testDistanceRequest);

        return new ResponseEntity<>(testDistance, HttpStatus.OK);
    }


}