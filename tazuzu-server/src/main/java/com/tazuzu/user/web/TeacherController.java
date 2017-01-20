package com.tazuzu.user.web;

import com.tazuzu.user.domain.Teacher;
import com.tazuzu.user.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teachers")
@SuppressWarnings("unused")
public class TeacherController {

    private final TeacherServiceImpl teacherService;

    @Autowired
    public TeacherController(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeacher() {
        return teacherService.getAllTeachers();
    }

    @GetMapping(value = "/{userId}")
    public Teacher getTeacher(@PathVariable long teacherId) {
        return teacherService.getTeacher(teacherId);
    }

    @PostMapping
    public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher) {
        teacher = teacherService.createTeacher(teacher).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }
}
