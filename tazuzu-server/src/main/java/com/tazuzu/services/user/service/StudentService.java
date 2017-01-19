package com.tazuzu.services.user.service;

import com.tazuzu.services.user.domain.Student;

import java.util.List;

/**
 * Created by nofarb on 17-Jan-17.
 */
public interface StudentService {
    public Student getStudent(Long studentId);
    public List<Student> getAllStudents();
    public Student createStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(Long studentId);
}
