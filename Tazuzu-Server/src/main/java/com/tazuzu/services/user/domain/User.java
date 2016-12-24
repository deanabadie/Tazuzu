package com.tazuzu.services.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    @Version
    private Date timestamp;

    public User(User user) {
        this.userId     = user.userId;
        this.firstName  = user.firstName;
        this.lastName   = user.lastName;
        this.email      = user.email;
    }

    public User(String firstName, String lastName, String email) {
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.email      = email;
    }

    User() {

    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "timestamp=" + timestamp +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
