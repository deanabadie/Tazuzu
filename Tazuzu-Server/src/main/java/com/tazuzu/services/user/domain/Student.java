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
public class Student extends User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long studentId;

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
    @NotNull
    private double height;
    @NotNull
    private double weight;
    @Version
    private Timestamp timeOfCreation;
    @Version
    private Timestamp timeOfLastEdit;
    @NotNull
    private Long lastEditBy;
    @NotNull
    private Long language;

    public Student(Student student) {
        this.studentId = student.studentId;
        this.id = student.id;
        this.userId = student.userId;
        this.gender = student.gender;
        this.dateOfBirth = student.dateOfBirth;
        this.groupId = student.groupId;
        this.height = student.height;
        this.weight = student.weight;
        this.lastEditBy = this.userId;
        this.timeOfCreation = new Timestamp(System.currentTimeMillis());
        this.timeOfLastEdit = new Timestamp(System.currentTimeMillis());
        this.language = student.language;
    }

    public Student(Long id, char gender, Date dateOfBirth, double height, double weight, Long language) {
        this.id = id;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
        this.language = language;
    }

    Student() {

    }

    public Long getUserId() throws Exception {
        return userId;
    }

    public Long getStudentId() throws Exception {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getId() throws Exception {
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double Weight) {
        weight = Weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double Height) {
        height = Height;
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

    public Long getLastEditBy() {
        return lastEditBy;
    }

    public void setLastEditBy(Long LastEditBy) {this.lastEditBy = LastEditBy; }

    public Long getLanguage() {
        return language;
    }

    public void setLanguage(Long language) {this.language = language; }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        Student obj = this;
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
