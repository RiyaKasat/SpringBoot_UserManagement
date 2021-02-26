package com.springboot.project.userdataapp.Services;



import com.springboot.project.userdataapp.API.APIResponse;
import com.springboot.project.userdataapp.DAO.UserRepository;
import com.springboot.project.userdataapp.Entities.Login;

import com.springboot.project.userdataapp.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserServices {

    @Autowired
    private UserRepository userRepository;
     PasswordEncoder passwordEncoder;

    //  public UserServices(UserRepository userRepository) {
    //   this.userRepository = userRepository;
    //   this.passwordEncoder = new BCryptPasswordEncoder();
    // }
  
    public User getUserByEmail(String email)
    {
      User user=null;
      
      try{
         user= this.userRepository.findByEmail(email);
         System.out.println("Inside GetUserByEmail"+ user);
        }
       catch(Exception e)
       {
         e.printStackTrace();
       }
        return user;
    }

   
    public APIResponse loginUser(Login loginModel) {
      User user1 = this.userRepository.findByEmail(loginModel.getEmail());
      System.out.println("User"+ user1);
     if(user1 == null) {
         throw new RuntimeException("User does not exist.");
     }
     if(!user1.getP().equals(loginModel.getPassword())){
         throw new RuntimeException("Password mismatch.");
     }
     return new APIResponse(200, "Login success", user1) ;
   }


    public User addUser(User u)
    {
      // String encodepassword= this.passwordEncoder.encode(u.getP());
      // u.setP(encodepassword);
      User res= userRepository.save(u);
      return res;
    }


	

    
}
