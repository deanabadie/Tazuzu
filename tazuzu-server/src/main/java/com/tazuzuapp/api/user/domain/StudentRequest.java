package com.tazuzuapp.api.user.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@SuppressWarnings("unused")
public class StudentRequest extends UserRequest{

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    @NotNull
    private Long govId;

    @NotEmpty
    private char gender;

    @NotNull
    private Long teacherId;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String schoolName;

    @NotEmpty
    private String schoolClass;

    @NotNull
    private double height;

    @NotNull
    private double weight;

    @NotEmpty
    private String photoPath;

    private Long id;

    private String type = "student";

    public StudentRequest(){}

    public StudentRequest(Student s){
        id = s.getId();
        firstName = s.getFirstName();
        lastName = s.getLastName();
        userName = s.getUserName();
        password = s.getPassword();
        govId = s.getGovId();
        gender = s.getGender();
        email = s.getEmail();
        schoolName = s.getSchool().toString();
        schoolClass = s.getSchoolClass().getName();
        height = s.getHeight();
        weight = s.getWeight();
        photoPath = s.getPhotoPath();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getGovId() {
        return govId;
    }

    public void setGovId(Long govId) {
        this.govId = govId;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
