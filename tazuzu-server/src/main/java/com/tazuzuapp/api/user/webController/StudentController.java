package com.tazuzuapp.api.user.webController;

import com.tazuzuapp.api.user.domain.Student;
import com.tazuzuapp.api.user.domain.StudentRequest;
import com.tazuzuapp.api.user.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController //Means everything we do will be converted into JSON and be sent as an HTTP response
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/students")
@SuppressWarnings("unused")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService studentService) {
        this.service = studentService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getEntity(@PathVariable Long id) {
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
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        if ( !service.exists(id) ) {
            throw new EntityNotFoundException("Could not find id " + id);
        }

        Student student = service.updateStudent(id, studentRequest);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentRequest studentRequest) {
        Student student = service.createStudent(studentRequest);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

}