package com.example.bookMyShow.service;

import com.example.bookMyShow.entity.User;
import com.example.bookMyShow.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User getUserByUsername(String userName) {
        User user = null;
        try{
            user =  userRepo.findByUsername(userName);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return user;
    }



    public void validateUser(String userName, String password) throws Exception {
        User user = userRepo.findByUsername(userName);
        if (user != null && user.getPassword().equals(password) ){
            return;
        }
        throw new Exception("Invalid username or password");
    }
}
