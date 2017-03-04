package com.tazuzu.user.webController;

import com.tazuzu.user.domain.Teacher;
import com.tazuzu.user.domain.TeacherRequest;
import com.tazuzu.user.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/teachers")
@SuppressWarnings("unused")
public class TeacherController {

    private final TeacherService service;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.service = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeacher() {
        return service.getAllTeachers();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Teacher> getEntity(@PathVariable Long id) {
        Teacher s = service.getTeacher(id);

        if ( s == null ) {
            throw new EntityNotFoundException("Could not find student with the given id (" + id + ")");
        }

        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody TeacherRequest teacherRequest) {
        if ( !service.exists(id) ) {
            throw new EntityNotFoundException("Could not find teacher with given id: " + id);
        }

        Teacher teacher = service.updateTeacher(id, teacherRequest);

        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody TeacherRequest teacherRequest) {
        Teacher teacher = service.createTeacher(teacherRequest);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

}
