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

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final SchoolRepository schoolRepository;

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
