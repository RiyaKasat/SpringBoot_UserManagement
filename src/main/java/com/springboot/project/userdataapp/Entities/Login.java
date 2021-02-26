package com.springboot.project.userdataapp.Entities;

public class Login {
    String email;
    String pass;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String pass) {
        this.pass = pass;
    }

    public Login(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }
    
}
