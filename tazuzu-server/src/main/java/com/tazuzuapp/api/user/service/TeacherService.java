package com.tazuzuapp.api.user.service;

import com.tazuzuapp.api.organization.domain.School;
import com.tazuzuapp.api.organization.repository.SchoolRepository;
import com.tazuzuapp.api.user.domain.Teacher;
import com.tazuzuapp.api.user.domain.TeacherRequest;
import com.tazuzuapp.api.user.repository.TeacherRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("unused")
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final SchoolRepository schoolRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository,
                          SchoolRepository schoolRepository) {
        this.teacherRepository = teacherRepository;
        this.schoolRepository = schoolRepository;
    }

    public Teacher getTeacher(Long teacherId) {
        return teacherRepository.getOne(teacherId);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher findOneById(long id) {
        return this.teacherRepository.findOne(id);
    }

    @Transactional
    public Teacher createTeacher(TeacherRequest teacherRequest) throws BadHttpRequest {
        Teacher newTeacher = new Teacher(teacherRequest);
        School school = schoolRepository.findOne(teacherRequest.getSchoolId());
        if ( school == null ) {
            throw new BadHttpRequest(new Exception("Could not find the given school"));
        }
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
        School school = schoolRepository.findOne(teacherRequest.getSchoolId());
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
