package com.springboot.project.userdataapp.DAO;

import com.springboot.project.userdataapp.Entities.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
    public User findByUsername(String username);
}