package com.tazuzuapp.api.organization.service;

import com.tazuzuapp.api.organization.domain.School;
import com.tazuzuapp.api.organization.domain.SchoolRequest;
import com.tazuzuapp.api.organization.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SchoolService {

    private final SchoolRepository repository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.repository= schoolRepository;
    }


    public School create(SchoolRequest schoolRequest) {
        School newSchool = new School();
        newSchool.setName(schoolRequest.getName());
        newSchool.setCity(schoolRequest.getCity());
        return repository.save(newSchool);
    }
    public School findOne(Long id) {
        return repository.findOne(id);
    }

    public List<School> findAll() {
        return repository.findAll();
    }
}
