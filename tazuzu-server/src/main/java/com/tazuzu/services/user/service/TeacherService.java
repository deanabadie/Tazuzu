package com.tazuzu.services.user.service;

import com.tazuzu.services.user.domain.Teacher;

import java.util.List;

/**
 * Created by nofarb on 17-Jan-17.
 */
public interface TeacherService {
    public Teacher getTeacher(Long teacherId);
    public List<Teacher> getAllTeachers();
    public Teacher createTeacher(Teacher teacher);
    public void updateTeacher(Teacher teacher);
    public void deleteTeacher(Long teacherId);
}
