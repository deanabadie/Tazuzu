package com.tazuzu.services.user.service;

import com.tazuzu.services.user.domain.Teacher;
import com.tazuzu.services.user.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nofarb on 17-Jan-17.
 */
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public Teacher getTeacher(Long teacherId) {
        return teacherRepository.getOne(teacherId);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Transactional
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
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
