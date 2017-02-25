package com.tazuzu.organization.webController;

import com.tazuzu.organization.domain.School;
import com.tazuzu.organization.domain.SchoolRequest;
import com.tazuzu.organization.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/schools")
@SuppressWarnings("unused")
public class SchoolController {
    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public ResponseEntity<School> createSchool(@RequestBody SchoolRequest schoolRequest) {
        School scl = schoolService.create(schoolRequest);

        if ( scl != null ) {
            return new ResponseEntity<>(scl, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<School> createSchool(@PathVariable Long id) {
        School scl = schoolService.findOne(id);

        if ( scl != null ) {
            return new ResponseEntity<>(scl, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
