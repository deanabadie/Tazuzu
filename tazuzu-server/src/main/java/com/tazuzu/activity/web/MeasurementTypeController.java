package com.tazuzu.activity.web;

import com.tazuzu.activity.domain.Activity;
import com.tazuzu.activity.domain.MeasurementType;
import com.tazuzu.activity.service.MeasurementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by deana on 11/03/2017.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/measurementTypes")
public class MeasurementTypeController {

    private final MeasurementTypeService service;

    @Autowired
    public MeasurementTypeController(MeasurementTypeService measurementTypeService) { this.service = measurementTypeService; }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MeasurementType> getEntity(@PathVariable Long id) {
        MeasurementType measurementType = service.getMeasurementType(id);

        if ( measurementType == null ) {
            throw new EntityNotFoundException("Could not find measurement type with the given id (" + id + ")");
        }

        return new ResponseEntity<>(measurementType, HttpStatus.OK);
    }

    @GetMapping
    public List<MeasurementType> getMeasurementTypes() {
        return service.getAllMeasurementTypes();
    }
}
