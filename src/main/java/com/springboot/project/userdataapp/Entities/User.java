package com.springboot.project.userdataapp.Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import java.text.ParseException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "Users")
public class User {

   
   
    @NonNull
    private String name, place;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
    @Column(name = "BirthDate")
    @NonNull
    private String dob;

    @Id
    @NonNull
    private String email;

    @NonNull
    String p;
    // private String pass;

    public User( String name, String place, String dob, String email, String p) {
       
        this.name = name;
        this.place = place;
        this.dob=dob;
        this.email=email;
        this.p=p;
       
        
    }

    public User() {
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

    @OneToMany(mappedBy = "user")
    List<LoginHistory> login_list=new ArrayList<LoginHistory>();

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
		return "User [dob=" + dob + ", id="  + ", name=" + name + ", password=" +p+", place=" + place
				+ ", email=" +email + "]";
	}

    
}