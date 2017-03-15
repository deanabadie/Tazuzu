package com.tazuzu.user.service;

import com.tazuzu.activity.domain.Activity;
import com.tazuzu.activity.domain.ActivityRequest;
import com.tazuzu.organization.domain.Class;
import com.tazuzu.organization.domain.ClassRequest;
import com.tazuzu.organization.domain.School;
import com.tazuzu.organization.repository.SchoolRepository;
import com.tazuzu.organization.service.ClassService;
import com.tazuzu.user.domain.Student;
import com.tazuzu.user.domain.Teacher;
import com.tazuzu.user.domain.TeacherRequest;
import com.tazuzu.user.repository.StudentRepository;
import com.tazuzu.user.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
