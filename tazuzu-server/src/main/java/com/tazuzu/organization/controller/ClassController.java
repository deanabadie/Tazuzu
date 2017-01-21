package com.tazuzu.organization.controller;

import com.tazuzu.organization.domain.Class;
import com.tazuzu.organization.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/classes")
@SuppressWarnings("unused")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    public static class ClassRequest {

        private String name;

        private Long schoolId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(Long schoolId) {
            this.schoolId = schoolId;
        }
    }

    @PostMapping
    public ResponseEntity<Class> createClass(@RequestBody ClassRequest classRequest) {
        Class cls = classService.create(classRequest);

        if ( cls != null ) {
            return new ResponseEntity<>(cls, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Class> createClass(@PathVariable Long id) {
        Class cls = classService.findOne(id);

        if ( cls != null ) {
            return new ResponseEntity<>(cls, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}