package com.tazuzuapp.api.user.domain;

import com.tazuzuapp.api.organization.domain.School;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@SuppressWarnings("unused")
public class Teacher extends User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Teacher() {}

    public Teacher(TeacherRequest teacherRequest){
        this.setFirstName(teacherRequest.getFirstName());
        this.setLastName(teacherRequest.getLastName());
        this.setPassword(teacherRequest.getPassword());
        this.setGovId(teacherRequest.getGovId());
        this.setGender(teacherRequest.getGender());
        this.setEmail(teacherRequest.getEmail());
        this.setActivated(true);
        this.setPhotoPath(teacherRequest.getPhotoPath());
        this.setDateOfBirth(teacherRequest.getDateOfBirth());
    }

    @Override
    public Long getId() {
        return this.id;
    }
}

