package com.springboot.project.userdataapp.Entities;



// Java program to demonstrate constuctors of Date 
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.lang.NonNull;

@Entity
public class LoginHistory {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private int id;

    @NonNull
    private String email;
    
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    @Column(nullable = false)
    private Date date;
    
    @PrePersist
    private void onCreate() {
        date = new Date();
    }



    public LoginHistory( int id, String email, Date date) {
        this.id=id;
        this.email = email;
        this.date = date;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLoginTime() {
        return date;
    }

    public void setLoginTime(Date loginTime) {
        this.date = date;
    }

    // @ManyToOne
    // @JoinColumn(name="email1", nullable=false)
    // private User user;


    @ManyToOne
    private User user;

    
    public LoginHistory() {
    }

    public LoginHistory(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    


    
}
