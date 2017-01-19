package com.tazuzu.services.user.service;

import com.tazuzu.services.user.domain.Student;
import com.tazuzu.services.user.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nofarb on 17-Jan-17.
 */
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student getStudent(Long studentId) {
        return studentRepository.getOne(studentId);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public void deleteStudent(Long studentId) {
        studentRepository.delete(studentId);
    }
}
