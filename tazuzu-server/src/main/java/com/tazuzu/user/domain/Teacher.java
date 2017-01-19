package com.tazuzu.user.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Teacher extends User {

    @NotNull
    private char gender;

    @NotNull
    private Date dateOfBirth;

    @NotNull
    private Long groupId;

    @Version
    private Timestamp timeOfCreation;

    @Version
    private Timestamp timeOfLastEdit;

    @NotNull
    private Long lastEditBy;

    @NotNull
    private Long language;

    public Teacher() {}

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public Timestamp getTimeOfCreation() {
        return timeOfCreation;
    }

    @Override
    public void setTimeOfCreation(Timestamp timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    @Override
    public Timestamp getTimeOfLastEdit() {
        return timeOfLastEdit;
    }

    @Override
    public void setTimeOfLastEdit(Timestamp timeOfLastEdit) {
        this.timeOfLastEdit = timeOfLastEdit;
    }

    @Override
    public Long getLastEditBy() {
        return lastEditBy;
    }

    @Override
    public void setLastEditBy(Long lastEditBy) {
        this.lastEditBy = lastEditBy;
    }

    public Long getLanguage() {
        return language;
    }

    public void setLanguage(Long language) {
        this.language = language;
    }
}

