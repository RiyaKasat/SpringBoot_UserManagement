package com.springboot.project.userdataapp.Services;

import java.util.List;

import com.springboot.project.userdataapp.API.APIResponse;
import com.springboot.project.userdataapp.DAO.LoginHistoryRepository;
import com.springboot.project.userdataapp.DAO.UserRepository;
import com.springboot.project.userdataapp.Entities.Login;
import com.springboot.project.userdataapp.Entities.LoginHistory;
import com.springboot.project.userdataapp.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginHistoryRepository loginHistoryRepository;

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

    
   
    public APIResponse loginUser(Login loginModel) 
    {
      User user1 = this.userRepository.findByEmail(loginModel.getEmail());
      List<LoginHistory> l= this.loginHistoryRepository.findByEmail(loginModel.getEmail());
      System.out.println("User -------"+ user1);
      for(int i=0;i<l.size();i++)
        {
         System.out.println("Inside getLoginHistoryByEmail"+ l);
        }
     if(user1 == null) {
      List<LoginHistory> l1=null;
        //  throw new RuntimeException("User does not exist.");
         return new APIResponse(401, "User does not exist.", user1, l1 ) ;
     }
     else

     if(!user1.getP().equals(loginModel.getPassword())){
      List<LoginHistory> l1=null;
      return new APIResponse(401, "User does not exist.", user1, l1 ) ;
        // throw new RuntimeException("Password mismatch.");
     }

     else
     {
        LoginHistory h=new LoginHistory(loginModel.getEmail());
        h.setEmail(loginModel.getEmail());
        addLoginHistory(h);
       
     }
     List<LoginHistory> l1= this.loginHistoryRepository.findByEmail(loginModel.getEmail());
     return new APIResponse(200, "Login success", user1, l1) ;
   }

   public User addUser(User u)
    {
      // String encodepassword= this.passwordEncoder.encode(u.getP());
      // u.setP(encodepassword);
      User res= userRepository.save(u);
      return res;
    }

    public LoginHistory addLoginHistory(LoginHistory h)
    {
      LoginHistory his=loginHistoryRepository.save(h);
      return his;
    }


}
