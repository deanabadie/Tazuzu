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
    private Date timeOfCreation;
    @Version
    private Date timeOfLastEdit;
    @NotNull
    private Long lastEditBy;

    public Student(Student student) {
        this.studentId = student.studentId;
        this.id = student.id;
        this.userId = student.userId;
        this.gender = student.gender;
        this.dateOfBirth = student.dateOfBirth;
        this.groupId = student.groupId;
        this.height = student.height;
        this.weight = student.weight;
        this.lastEditBy = this.id;

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date();
        try {
            this.timeOfCreation = formatter.parse(formatter.format(date1));
            this.timeOfLastEdit = formatter.parse(formatter.format(date1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Student(Long id, char gender, Date dateOfBirth, double height, double weight) {
        this.id = id;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
    }

    Student() {

    }

    public Long getUserId() {
        return userId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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
                ", studentId=" + studentId +
                ", id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", groupId='" + groupId + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }

}
