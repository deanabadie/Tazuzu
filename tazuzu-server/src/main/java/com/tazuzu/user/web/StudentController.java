package com.tazuzu.user.web;

import com.tazuzu.user.domain.Student;
import com.tazuzu.user.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping(name = "/student")
public class StudentController {

    private final StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    /**
     * GET - /api/student/{userId}
     * @param studentId
     * @return
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable long studentId) {
        return studentService.getStudent(studentId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        student = studentService.createStudent(student);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
}