package com.tazuzuapp.api.user.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

@SuppressWarnings("unused")
public class TeacherRequest extends UserRequest {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String password;

    @NotNull
    private Long govId;

    @NotEmpty
    private char gender;

    private Date dateOfBirth;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private long schoolId;

    private String photoPath;

    public TeacherRequest() {}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long school) {
        this.schoolId = school;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Long getGovId() {
        return govId;
    }

    public void setGovId(Long govId) {
        this.govId = govId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
