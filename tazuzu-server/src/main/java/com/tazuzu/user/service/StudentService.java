package com.tazuzu.user.service;

import com.tazuzu.organization.domain.Class;
import com.tazuzu.organization.domain.School;
import com.tazuzu.organization.repository.ClassRepository;
import com.tazuzu.organization.repository.SchoolRepository;
import com.tazuzu.user.domain.Student;
import com.tazuzu.user.domain.StudentRequest;
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
public class StudentService {

    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final SchoolRepository schoolRepository;
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
    public StudentService(StudentRepository studentRepository, ClassRepository classRepository, SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
        this.schoolRepository = schoolRepository;
    }

    public Student getStudent(Long studentId) {
        return studentRepository.findOne(studentId);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student createStudent(StudentRequest s) {
        Student newStudent = new Student(s);
        School school = schoolRepository.findByName(s.getSchoolName());
        newStudent.setSchool(school);
        Class schoolClass = classRepository.findBySchoolNameAndName(s.getSchoolName(), s.getSchoolClass());
        newStudent.setSchoolClass(schoolClass);
        return studentRepository.save(newStudent);
    }

    @Transactional
    public Student updateStudent(Long id, StudentRequest studentRequest) {

        Student originalStudent = studentRepository.findOne(id);

        Student newStudent = new Student(studentRequest);
        newStudent.setCreatedAt(originalStudent.getCreatedAt());
        newStudent.setDeletedAt(originalStudent.getDeletedAt());
        newStudent.setId(id);
        School school = schoolRepository.findByName(studentRequest.getSchoolName());
        newStudent.setSchool(school);
        Class schoolClass = classRepository.findBySchoolNameAndName(studentRequest.getSchoolName(), studentRequest.getSchoolClass());
        newStudent.setSchoolClass(schoolClass);
        return studentRepository.save(newStudent);
    }

    public Boolean exists(Long id) {
        return studentRepository.exists(id);
    }

}
