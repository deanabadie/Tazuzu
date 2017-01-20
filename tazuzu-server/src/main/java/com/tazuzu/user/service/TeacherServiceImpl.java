package com.tazuzu.user.service;

import com.tazuzu.user.domain.Teacher;
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

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher getTeacher(Long teacherId) {
        return teacherRepository.getOne(teacherId);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Transactional
    public Optional<Teacher> createTeacher(Teacher teacher) {
        return Optional.of(teacherRepository.save(teacher));
    }

    @Transactional
    public void updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Transactional
    public void deleteTeacher(Long teacherId) {
        teacherRepository.delete(teacherId);
    }
}
