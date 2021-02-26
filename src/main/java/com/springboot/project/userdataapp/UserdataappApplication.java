package com.springboot.project.userdataapp;

import java.util.Scanner;

import com.springboot.project.userdataapp.Entities.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class UserdataappApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserdataappApplication.class, args);
		System.out.println("Running...");
		
	}


}
