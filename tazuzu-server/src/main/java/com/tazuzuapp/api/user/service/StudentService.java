package com.tazuzuapp.api.user.service;

import com.tazuzuapp.api.organization.domain.Class;
import com.tazuzuapp.api.organization.domain.School;
import com.tazuzuapp.api.organization.repository.ClassRepository;
import com.tazuzuapp.api.organization.repository.SchoolRepository;
import com.tazuzuapp.api.user.domain.Student;
import com.tazuzuapp.api.user.domain.StudentRequest;
import com.tazuzuapp.api.user.repository.StudentRepository;
import com.tazuzuapp.api.user.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, ClassRepository classRepository,
                          TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
        this.teacherRepository = teacherRepository;
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
        newStudent.setTeacher(teacherRepository.findOne(s.getTeacherId()));
        Class schoolClass = classRepository.findOne(s.getClassId());
        newStudent.setSchool(schoolClass.getSchool());
        newStudent.setSchoolClass(schoolClass);

        return studentRepository.save(newStudent);
    }

    @Transactional
    public Student updateStudent(Long id, StudentRequest studentRequest) {
        Student student = studentRepository.findOne(id);
        student.setTeacher(teacherRepository.findOne(studentRequest.getTeacherId()));
        student.setId(id);
        Class schoolClass = classRepository.findOne(studentRequest.getClassId());
        student.setSchoolClass(schoolClass);
        student.setSchool(schoolClass.getSchool());

        return studentRepository.save(student);
    }

    public Boolean exists(Long id) {
        return studentRepository.exists(id);
    }
}
