package com.springboot.project.userdataapp.Controllers;

import java.util.Optional;

import com.springboot.project.userdataapp.API.APIResponse;
import com.springboot.project.userdataapp.Entities.Login;

import com.springboot.project.userdataapp.Entities.User;
import com.springboot.project.userdataapp.Services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class UserController {

  @Autowired
  private UserServices userServices;


  @PostMapping(value = "/AddUser")
  public ResponseEntity<User> addUser(@RequestBody User user) {
    System.out.println(userServices.getUserByEmail(user.getEmail()));
    User u = userServices.getUserByEmail(user.getEmail());
    System.out.println("Inside Controller"+user);
     boolean bool=false;
    if (u == null) {
      try 
      {
        u = this.userServices.addUser(user);
        System.out.println(u);
        bool=true;
      } 
      catch (Exception e) 
      {
        e.printStackTrace();
        bool=false;
        
      }
     
    }
    if(bool) return ResponseEntity.of(Optional.of(u));
    else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
   
  }

  
  @PostMapping(value ="/Login1/")
  public APIResponse UserLogin(@RequestBody Login login)
      {
        APIResponse a1= userServices.loginUser(login);
        User u= (User) a1.getResult();
        u.setP("");
        a1.setResult(u);
        return a1;
      }

  

  
 }