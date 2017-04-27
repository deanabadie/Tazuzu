package com.tazuzuapp.api.organization.service;

import com.tazuzuapp.api.organization.domain.ClassRequest;
import com.tazuzuapp.api.organization.domain.Class;
import com.tazuzuapp.api.organization.domain.School;
import com.tazuzuapp.api.organization.repository.ClassRepository;
import com.tazuzuapp.api.organization.repository.SchoolRepository;
import com.tazuzuapp.api.user.domain.Student;
import com.tazuzuapp.api.user.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;
    private final ClassRepository repository;

    @Autowired
    public ClassService(ClassRepository classRepository, SchoolRepository schoolRepository,
                        StudentRepository studentRepository) {
        this.repository = classRepository;
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
    }

    public Class create(ClassRequest classRequest) {
        Class newClass = new Class();
        newClass.setName(classRequest.getName());
        newClass.setSchool(schoolRepository.findOne(classRequest.getSchoolId()));
        return repository.save(newClass);
    }

    public Class findOne(Long id) {
        return repository.findOne(id);
    }

    public void sendActivityToAll(Class cls) {
        List<Student> allStudents = studentRepository.findBySchoolClass(cls);
        for (Student s: allStudents){
//            s.updateActivity
            System.out.print("Class and id: [" + s.getSchoolClass().getName() +", "+ s.getId() + "]");
        }
    }

    public List<Class> findClassesBySchoolId(Long schoolId){
        School s = schoolRepository.findOne(schoolId);
        return repository.findBySchool(s);
    }

//    public List<Student> getClassStudents(Class cls){
//
//        List<Student> ans = studentRepository.findByClass(cls.getId());
//        return ans;
//    }
}
