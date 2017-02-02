package com.tazuzu.user.web;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tazuzu.user.domain.Student;
import com.tazuzu.user.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController //Means everything we do will be converted into JSON and be sent as an HTTP response
@RequestMapping(value = "/students")
@SuppressWarnings("unused")
public class StudentController {

    private final StudentServiceImpl service;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.service = studentService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getEntity(@PathVariable  Long id) {
        Student s = service.getStudent(id);

        if ( s == null ) {
            throw new EntityNotFoundException("Could not find student with the given id (" + id + ")");
        }

        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        if ( !service.exists(id) ) {
            throw new EntityNotFoundException("Could not ...");
        }

        student = service.updateStudent(student);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        student = service.createStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

}