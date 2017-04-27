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
    private final SchoolRepository schoolRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, ClassRepository classRepository,
                          SchoolRepository schoolRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
        this.schoolRepository = schoolRepository;
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
        newStudent.setTeacher(teacherRepository.findOne(studentRequest.getTeacherId()));
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
