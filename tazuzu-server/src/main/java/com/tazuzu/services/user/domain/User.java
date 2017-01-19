package com.tazuzu.services.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
//import java.security.Timestamp;
import java.util.Date;
import java.sql.Timestamp;

/**
 * Created by nati1 on 3/25/15.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;

    @Column(unique = true, nullable = false)
    @NotNull
    private String userName;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @Column(unique = true, nullable = true)
    private String email;
    @JsonIgnore
    private String Password;
    @NotNull
    private Date registrationDate;
    @NotNull
    private boolean isActivated;
    @NotNull
    private boolean isAdmin;
    @NotNull
    private String photoPath;
    @NotNull
    private Timestamp timeOfCreation;
    @NotNull
    private Timestamp timeOfLastEdit;

    private Long LastEditBy;

    public User(User user) {
        this.userName = user.userName;
        this.firstName  = user.firstName;
        this.lastName   = user.lastName;
        this.email      = user.email;
        this.Password = user.Password;
        this.registrationDate = new Timestamp(System.currentTimeMillis());
        this.isActivated = true;
        this.isAdmin = false;
        this.photoPath = user.photoPath;
        this.timeOfCreation = new Timestamp(System.currentTimeMillis());
        this.timeOfLastEdit = this.timeOfCreation;
        this.LastEditBy = user.userId;
    }

    public User(String userName,String firstName, String lastName, String email,String Password,
                   String photoPath) {
        this.userName = userName;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.email      = email;
        this.Password = Password;
        this.registrationDate = new Timestamp(System.currentTimeMillis());
        this.isActivated = true;
        this.isAdmin = false;
        this.photoPath = photoPath;
        this.timeOfCreation = new Timestamp(System.currentTimeMillis());
        this.timeOfLastEdit = this.timeOfCreation;
        this.LastEditBy = userId;
    }

    User() {

    }

    public Long getUserId() throws Exception {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {return firstName;}

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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean getIsActivated() {
        return isActivated;
    }

    public void setIsActiveted(boolean isActivated) {
        this.isActivated = isActivated;
    }
    public boolean getIsAdmin() {
        return isAdmin;
    }

    public Timestamp getTimeOfCreation() {
        return timeOfCreation;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Timestamp getTimeOfLastEdit() {
        return timeOfLastEdit;
    }

    public void setTimeOfLastEdit(Timestamp timeOfLastEdit) {
        this.timeOfLastEdit = timeOfLastEdit;
    }

    public Long getLastEditBy() {
        return LastEditBy;
    }

    public void setLastEditBy(Long lastEditBy) {
        this.LastEditBy = lastEditBy;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        User obj = this;
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
