package com.tazuzu.user.service;

import com.tazuzu.organization.domain.School;
import com.tazuzu.organization.repository.ClassRepository;
import com.tazuzu.organization.repository.SchoolRepository;
import com.tazuzu.user.domain.Teacher;
import com.tazuzu.user.domain.TeacherRequest;
import com.tazuzu.user.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@Service
public class TeacherServiceImpl{

    private final TeacherRepository teacherRepository;
    private final ClassRepository classRepository;
    private final SchoolRepository schoolRepository;


    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, ClassRepository classRepository, SchoolRepository schoolRepository) {
        this.teacherRepository = teacherRepository;
        this.classRepository = classRepository;
        this.schoolRepository = schoolRepository;
    }

    public Teacher getTeacher(Long teacherId) {
        return teacherRepository.getOne(teacherId);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Transactional
    public Teacher createTeacher(TeacherRequest teacherRequest) {
        Teacher newTeacher = new Teacher(teacherRequest);
        School school = schoolRepository.findByName(teacherRequest.getSchoolName());
        newTeacher.setSchool(school);
        return teacherRepository.save(newTeacher);
    }

    @Transactional
    public Teacher updateTeacher(Long id, TeacherRequest teacherRequest) {
        Teacher originalTeacher = teacherRepository.findOne(id);

        Teacher newTeacher = new Teacher(teacherRequest);
        newTeacher.setCreatedAt(originalTeacher.getCreatedAt());
        newTeacher.setDeletedAt(originalTeacher.getDeletedAt());
        newTeacher.setId(id);
        School school = schoolRepository.findByName(teacherRequest.getSchoolName());
        newTeacher.setSchool(school);
        return teacherRepository.save(newTeacher);
    }

    @Transactional
    public void deleteTeacher(Long teacherId) {
        teacherRepository.delete(teacherId);
    }

    public Boolean exists(Long id) {
        return teacherRepository.exists(id);
    }
}
