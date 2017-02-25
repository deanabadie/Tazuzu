package com.tazuzu.organization.service;

import com.tazuzu.organization.domain.ClassRequest;
import com.tazuzu.organization.domain.Class;
import com.tazuzu.organization.repository.ClassRepository;
import com.tazuzu.organization.repository.SchoolRepository;
import com.tazuzu.user.domain.Student;
import com.tazuzu.user.repository.StudentRepository;
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

//    public List<Student> getClassStudents(Class cls){
//
//        List<Student> ans = studentRepository.findByClass(cls.getId());
//        return ans;
//    }
}
