package com.tazuzuapp.api.user.service;

import com.tazuzuapp.api.activity.domain.Activity;
import com.tazuzuapp.api.activity.domain.ActivityRequest;
import com.tazuzuapp.api.organization.domain.Class;
import com.tazuzuapp.api.organization.domain.ClassRequest;
import com.tazuzuapp.api.organization.domain.School;
import com.tazuzuapp.api.organization.repository.SchoolRepository;
import com.tazuzuapp.api.organization.service.ClassService;
import com.tazuzuapp.api.user.domain.Student;
import com.tazuzuapp.api.user.domain.Teacher;
import com.tazuzuapp.api.user.domain.TeacherRequest;
import com.tazuzuapp.api.user.repository.StudentRepository;
import com.tazuzuapp.api.user.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("unused")
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;
    private final ClassService classService;


    @Autowired
    public TeacherService(TeacherRepository teacherRepository, StudentRepository studentRepository,
                          SchoolRepository schoolRepository, ClassService classService) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
        this.classService = classService;
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

    @Transactional
    public List<Student> getTeachersClassStudents(Class cls){
        return studentRepository.findBySchoolClass(cls);
    }

    public Activity sendActivityToClass(ActivityRequest activityRequest, ClassRequest clsRequest){
        Class cls = new Class();
        Class newClass = new Class();
        newClass.setName(clsRequest.getName());
        newClass.setSchool(schoolRepository.findOne(clsRequest.getSchoolId()));
        classService.sendActivityToAll(cls);

        Activity activity = new Activity();
        activity.setActivityName(activityRequest.getActivityName());
        activity.setActivityTypeId(activityRequest.getActivityTypeId());
        activity.setNumOfMeasurements(activityRequest.getNumOfMeasurements());

        classService.sendActivityToAll(cls);
        return activity;
    }
}
