package com.springboot.project.userdataapp.Controllers;

import java.util.List;
import java.util.Optional;

import com.springboot.project.userdataapp.DAO.UserRepository;
import com.springboot.project.userdataapp.Entities.Login;
import com.springboot.project.userdataapp.Entities.User;
import com.springboot.project.userdataapp.Services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class UserController {

    @Autowired
    private UserServices userServices;
    private List<User> list;

    

    // @GetMapping(value="/Users")
    // public ResponseEntity<List<User>> getUsers()
    // {
    //   List<User> l= userServices.getAllUsers();
    //   if(l.size()<=0)
    //   {
    //     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    //   }
    //   return ResponseEntity.status(HttpStatus.CREATED).body(l);
    // }

    // @GetMapping(value="/Users/{id}")
    // public ResponseEntity<User> getUserByID(@PathVariable("id") int id)
    // {
    //   User u=userServices.getUserByEmail(id);
    //   if(u==null)
    //   {
    //     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    //   }
    //   return ResponseEntity.of(Optional.of(u));
    // }

    @PostMapping(value="/AddUser")
    public ResponseEntity<User> addUser(@RequestBody User user)
     {
       System.out.println(userServices.getUserByEmail(user.getUsername()));
      User u=userServices.getUserByEmail(user.getUsername());
      
      if(u==null)
      {
          try{
          u=new User();
          u= this.userServices.addUser(user);
          System.out.println(u);
          return ResponseEntity.of(Optional.of(u));

        }
        catch(Exception e)
        {
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
      } 
         
      return ResponseEntity.of(Optional.of(u));
     }


     @PostMapping(value="/Login")
     public ResponseEntity<User> addUser(@RequestBody Login login)
      {

       User u= userServices.getUserByEmail(login.getUsername());
       if(u==null)
       {
        return ResponseEntity.of(Optional.of(u));
       }
       else
       {
        if(!u.getPassword().equals(login.getPassword()))
         {
          return ResponseEntity.of(Optional.of(u));
         }
         
       }
        return ResponseEntity.of(Optional.of(u));
      }
}
