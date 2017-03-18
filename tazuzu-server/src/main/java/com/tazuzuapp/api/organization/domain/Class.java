package com.tazuzuapp.api.organization.domain;

import com.tazuzuapp.api.general.domain.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity

@SuppressWarnings("unused")
public class Class extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    private School school;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
