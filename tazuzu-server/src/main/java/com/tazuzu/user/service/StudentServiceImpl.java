package com.tazuzu.user.service;

import com.tazuzu.user.domain.Student;
import com.tazuzu.user.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Again... @Service is just another type of @Component
 * Each class annotated with @Service is treated inside the Spring container
 * and can be injected to other Spring components
 */
@Service
public class StudentServiceImpl {

    private final StudentRepository studentRepository;

    /**
     * Auto wired is injecting a service representing the required type
     * Because we declared StudentRepository as a @Repository (which is just another type of @Component)
     * We can inject every service/repository/component into other Spring components by using the autowired annotation
     * You just declare a new constructor with all the types that you want to use and Spring is doing it for you...
     *
     * The initial example you did was declaring Autowired on a property and not on the constructor - which is bad practice
     * Do not do it :)
     */
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudent(Long studentId) {
        return studentRepository.findOne(studentId);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student createStudent(Student s) {
        Student newStudent = new Student();
        newStudent.setEmail(s.getEmail());
        newStudent.setFirstName(s.getFirstName());
        newStudent.setLastName(s.getLastName());
        newStudent.setGroupId(s.getGroupId());
        newStudent.setPhotoPath(s.getPhotoPath());
        newStudent.setUserName(s.getUserName());
        newStudent.setActivated(true);
        newStudent.setUserId(s.getUserId());

        return studentRepository.save(newStudent);
    }

    @Transactional
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public Boolean exists(Long id) {
        return studentRepository.exists(id);
    }

}
