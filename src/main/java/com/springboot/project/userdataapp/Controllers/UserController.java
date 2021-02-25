package com.springboot.project.userdataapp.Controllers;

import java.util.List;

import com.springboot.project.userdataapp.Entities.User;
import com.springboot.project.userdataapp.Services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UserController {

    @Autowired
    private UserServices userServices;
    private List<User> list;

    @GetMapping(value="/Users")
    public List<User> getUsers()
    {
      return this.userServices.getAllUsers();
    }

    @GetMapping(value="/Users/{id}")
    public User getUserByID(@PathVariable("id") int id)
    {
      return this.userServices.getUserById(id);
    }

    @PostMapping("/AddUser")
    public User addUser(@RequestBody User u)
    {
        
         User u1= this.userServices.addUser(u);
          return u1;
    }

    @DeleteMapping("Users/{userid}")
    public User deleteUser(@PathVariable("userid") int id){
        this.userServices.deleteUser();
    }

}
