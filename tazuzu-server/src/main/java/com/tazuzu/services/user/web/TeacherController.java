package com.tazuzu.services.user.web;

import com.tazuzu.services.user.domain.Teacher;
import com.tazuzu.services.user.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by nofarb on 17-Jan-17.
 */
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Teacher> getTeacher() {
        return teacherService.getAllTeachers();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Teacher getTeacher(@PathVariable long teacherId) {
        return teacherService.getTeacher(teacherId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher) {
        teacherService.createTeacher(teacher);
        return new ResponseEntity<Object>(null, null, HttpStatus.CREATED);
    }
}
