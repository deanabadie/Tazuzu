package com.tazuzu.services.user.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by noy on 13/01/2017.
 */
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
    private Date timeOfCreation;
    @Version
    private Date timeOfLastEdit;
    @NotNull
    private Long lastEditBy;

    public Teacher(Teacher teacher) {
        this.teacherId = teacher.teacherId;
        this.id = teacher.id;
        this.userId = teacher.userId;
        this.gender = teacher.gender;
        this.dateOfBirth = teacher.dateOfBirth;
        this.groupId = teacher.groupId;
        this.lastEditBy = this.id;

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date();
        try {
            this.timeOfCreation = formatter.parse(formatter.format(date1));
            this.timeOfLastEdit = formatter.parse(formatter.format(date1));
        } catch (ParseException e) {
            Date date2;
            date2 = new Date(2000,01,01);
            this.timeOfCreation = date2;
            this.timeOfLastEdit = date2;
            e.printStackTrace();
        }
    }

    public Teacher(Long id, char gender, Date dateOfBirth) {
        this.id = id;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
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

    public Date getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(Date TimeOfCreation) {
        this.timeOfCreation = TimeOfCreation;
    }

    public Date getTimeOfLastEdit() {
        return timeOfLastEdit;
    }

    public void setTimeOfLastEdit(Date TimeOfLastEdit) {
        this.timeOfLastEdit = TimeOfLastEdit;
    }

    public Long getLastEditBy() {
        return lastEditBy;
    }

    public void setLastEditBy(Long LastEditBy) {this.lastEditBy = LastEditBy; }

    @Override
    public String toString() {
        return "Student{" +
                "timeOfCreation=" + timeOfCreation +
                ", teacherId=" + teacherId +
                ", id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}

