package com.tazuzu.organization.service;

import com.tazuzu.organization.webController.ClassController;
import com.tazuzu.organization.domain.Class;
import com.tazuzu.organization.repository.ClassRepository;
import com.tazuzu.organization.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    private final SchoolRepository schoolRepository;

    private final ClassRepository repository;

    @Autowired
    public ClassService(ClassRepository classRepository, SchoolRepository schoolRepository) {
        this.repository = classRepository;
        this.schoolRepository= schoolRepository;
    }

    public Class create(ClassController.ClassRequest classRequest) {
        Class newClass = new Class();
        newClass.setName(classRequest.getName());
        newClass.setSchool(schoolRepository.findOne(classRequest.getSchoolId()));
        return repository.save(newClass);
    }

    public Class findOne(Long id) {
        return repository.findOne(id);
    }

    }
