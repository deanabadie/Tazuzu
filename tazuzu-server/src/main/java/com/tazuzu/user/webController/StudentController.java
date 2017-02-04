package com.tazuzu.user.webController;

import com.tazuzu.user.domain.Student;
import com.tazuzu.user.domain.StudentRequest;
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
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        if ( !service.exists(id) ) {
            throw new EntityNotFoundException("Could not find id " + id);
        }

        Student student = service.updateStudent(id, studentRequest);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

//    @PutMapping(value = "/{username}")
//    public ResponseEntity<Student> updateStudent(@PathVariable String username, @RequestBody StudentRequest studentRequest) {
//
////        if ( !service.exists(username) ) {
////            throw new EntityNotFoundException("Could not ...");
////        }
//
//        Student student = service.updateStudent(studentRequest);
//
//        return new ResponseEntity<>(student, HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentRequest studentRequest) {
        Student student = service.createStudent(studentRequest);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

}