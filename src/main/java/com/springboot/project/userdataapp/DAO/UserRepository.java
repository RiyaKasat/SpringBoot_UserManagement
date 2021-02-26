package com.springboot.project.userdataapp.DAO;

import com.springboot.project.userdataapp.Entities.User;

import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<User, String>{
    
   public User findByEmail(String email);
}