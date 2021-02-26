package com.springboot.project.userdataapp.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
  
@Entity @Table(name="Users")
public class User 
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private int id;
    private String name, place, dob;
    private String username, password;
    


    public User(int id, String name, String place, String dob, String username, String password) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.dob=dob;
        this.username=username;
        this.password=password;
        
    }

    public User() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return dob;
    }

    public void setDate(String dob) {
        this.dob = dob;
    }

  

	

	



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", place=" + place + "]";
	}

}
