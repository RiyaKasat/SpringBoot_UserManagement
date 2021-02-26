package com.springboot.project.userdataapp.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.springboot.project.userdataapp.DAO.UserRepository;
import com.springboot.project.userdataapp.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserServices {

    @Autowired
    private UserRepository userRepository;
    


    public List<User> getAllUsers(){
       List<User> list= (List) this.userRepository.findAll();
       return list;
    }

    public User getUserByEmail(String email)
    {
        User user=null;
        try{
          //user= list.stream().filter(e -> e.getId() == id).findFirst().get();
         user=  this.userRepository.findByUsername(email);
        }
       catch(Exception e)
       {
         e.printStackTrace();
       }
        return user;
    }

    public User addUser(User u)
    {
      // list.add(u);
      // return u;
      
      User res= userRepository.save(u);
      return res;
    }

    
}
