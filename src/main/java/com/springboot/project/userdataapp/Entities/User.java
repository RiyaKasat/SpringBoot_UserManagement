package com.springboot.project.userdataapp.Entities;

import java.util.Date;
import java.text.SimpleDateFormat;


import java.text.ParseException;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
  
  
@Entity @Table(name="Users")
public class User 
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private int id;
    private String name, place;

    @JsonFormat(pattern = "yyyy-MM-dd", shape= Shape.STRING)
    @Column(name="BirthDate")
    private String dob;
    private String email;
    String p;
    // private String pass;
    


    public User(int id, String name, String place, String dob, String email, String p) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.dob=dob;
        this.email=email;
        this.p=p;
       
        
    }

    public User() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getP()
    {
        return p;
    }

    public void setP(String p)
    {
        this.p=p;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    
    
    
    // public String getPassword() {
    //     return pass;
    // }

    // public void setPassword(String pass) {
    //     this.pass = pass;
    // }


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
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
         SimpleDateFormat format2 = new SimpleDateFormat("dd MMM yyyy");
         Date date;
    try {
        date =  format1.parse(dob);
        String temp = format2.format(date);
        return temp;
    }
 catch (ParseException e) {
   
    e.printStackTrace();
    return "A";
    
}
    }



    public void setDate(String dob) {
        this.dob = dob;
    }

	@Override
	public String toString() {
		return "User [dob=" + dob + ", id=" + id + ", name=" + name + ", password=" +p+", place=" + place
				+ ", email=" +email + "]";
	}

    
}