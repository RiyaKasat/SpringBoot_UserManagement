package com.springboot.project.userdataapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class UserdataappApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserdataappApplication.class, args);
		System.out.println("a");
	}


}
