package com.tazuzu.organization.service;

import com.tazuzu.organization.domain.School;
import com.tazuzu.organization.domain.SchoolRequest;
import com.tazuzu.organization.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

}
