package com.tazuzu.services.user.web;

import com.tazuzu.services.user.domain.Student;
import com.tazuzu.services.user.domain.User;
import com.tazuzu.services.user.service.StudentService;
import com.tazuzu.services.user.service.UserService;
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
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable long studentId) {
        return studentService.getStudent(studentId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return new ResponseEntity<Object>(null, null, HttpStatus.CREATED);
    }
}
