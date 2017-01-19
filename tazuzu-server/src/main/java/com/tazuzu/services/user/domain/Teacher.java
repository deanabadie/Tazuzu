package com.tazuzu.services.user.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by noy on 13/01/2017.
 */
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long teacherId;

    @Column(unique = true, nullable = false)
    @NotNull
    private Long id;
    @NotNull
    private Long userId;
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

    public Teacher(Teacher teacher) {
        this.teacherId = teacher.teacherId;
        this.id = teacher.id;
        this.userId = teacher.userId;
        this.gender = teacher.gender;
        this.dateOfBirth = teacher.dateOfBirth;
        this.groupId = teacher.groupId;
        this.lastEditBy = this.id;
        this.timeOfCreation = new Timestamp(System.currentTimeMillis());
        this.timeOfLastEdit = new Timestamp(System.currentTimeMillis());
        this.language = teacher.language;
    }

    public Teacher(Long id, char gender, Date dateOfBirth, Long language) {
        this.id = id;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.language = language;
    }

    Teacher() {

    }

    public Long getUserId() {
        return userId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long TeacherId) {
        this.teacherId = TeacherId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id; }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.dateOfBirth = DateOfBirth;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long GroupId) {this.groupId = GroupId; }

    public Timestamp getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(Timestamp TimeOfCreation) {
        this.timeOfCreation = TimeOfCreation;
    }

    public Timestamp getTimeOfLastEdit() {
        return timeOfLastEdit;
    }

    public void setTimeOfLastEdit(Timestamp TimeOfLastEdit) {
        this.timeOfLastEdit = TimeOfLastEdit;
    }

    public Long getLastEditBy() {return lastEditBy;}

    public void setLastEditBy(Long LastEditBy) {this.lastEditBy = LastEditBy; }

    public Long getLanguage() {
        return language;
    }

    public void setLanguage(Long language) {this.language = language; }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        Teacher obj = this;
        String jsonInString = "";
        //Object to JSON in String
        try {
            jsonInString = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  jsonInString;
    }
}

