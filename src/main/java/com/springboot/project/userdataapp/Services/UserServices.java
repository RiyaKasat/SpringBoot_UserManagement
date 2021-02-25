package com.springboot.project.userdataapp.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.springboot.project.userdataapp.Entities.User;

import org.springframework.stereotype.Component;
@Component
public class UserServices {
    private static List<User> list=new ArrayList<User>();


    public List<User> getAllUsers(){
        return list;
    }

    public User getUserById(int id)
    {
        User user=null;
        user= list.stream().filter(e -> e.getId() == id).findFirst().get();
        return user;
    }

    public User addUser(User u)
    {
      list.add(u);
      return u;
    }

    public void deleteUser(int userId)
    {
      list.stream().filter(user ->user.getId()!=userId).collect(Collectors.toList());
    }
}
