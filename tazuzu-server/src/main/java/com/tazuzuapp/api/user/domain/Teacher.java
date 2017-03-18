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

    @NotNull
    @ManyToOne
    private School school;

    public Teacher() {}

    public Teacher(TeacherRequest teacherRequest){
        this.setEmail(teacherRequest.getEmail());
        this.setPassword(teacherRequest.getPassword());
        this.setActivated(true);
        this.setFirstName(teacherRequest.getFirstName());
        this.setGender(teacherRequest.getGender());
        this.setLastName(teacherRequest.getLastName());
        this.setUserName(teacherRequest.getUserName());
        this.setPhotoPath(teacherRequest.getPhotoPath());
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}

