package com.tazuzuapp.api.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tazuzuapp.api.general.domain.BaseEntity;
import com.tazuzuapp.api.organization.domain.School;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
@SuppressWarnings("unused")
public abstract class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @JsonIgnore
    @NotNull
    private String password;

    @NotNull
    @ManyToOne
    private School school;

    @JsonIgnore
    @NotNull
    private boolean isActivated = true;

    @NotNull
    @Column(length = 1000)
    private String photoPath;

    @Column(unique = true)
    @NotNull
    private Long govId;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @NotNull
    private char gender;

    public User() {}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
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

    public Long getGovId() {
        return govId;
    }

    public void setGovId(Long govId) {
        this.govId = govId;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
