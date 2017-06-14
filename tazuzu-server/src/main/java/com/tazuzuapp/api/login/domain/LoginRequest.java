package com.tazuzuapp.api.login.domain;

@SuppressWarnings("all")
public class LoginRequest {

    Long idNumber;

    String password;

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
