package com.springsecuritydemo.models;

import com.springsecuritydemo.annotations.IsPasswordConfirmed;

import javax.validation.constraints.Size;

@IsPasswordConfirmed
public class RegisterModel {

    @Size(min = 5, message = "Username must be at least 5 characters")
    private String username;

    @Size(min = 5, message = "Password must be at least 5 characters")
    private String password;

    private String confirmPassword;

    public RegisterModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
