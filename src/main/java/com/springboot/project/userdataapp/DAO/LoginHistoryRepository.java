package com.springboot.project.userdataapp.DAO;

import java.util.List;

import com.springboot.project.userdataapp.Entities.LoginHistory;

import org.springframework.data.repository.CrudRepository;

public interface LoginHistoryRepository extends CrudRepository<LoginHistory, String>
{
    public List<LoginHistory> findByEmail(String email);
}
    

