package com.user.controller;

import com.user.model.User;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostMapping("/add")
    public String addUser(@RequestBody User user)throws Exception{
        if(userRepository.findById(user.getUserId()).isPresent()){
            throw new Exception("user already exists");
        }
        else {
            String pwd = user.getPassword();
            String encodedPwd = encoder.encode(pwd);
            user.setPassword(encodedPwd);
            userRepository.save(user);
            return "user added successfully";
        }
    }
    @PutMapping("/update")
    public String updateUser(@RequestBody User user) throws Exception{
        if(userRepository.findById(user.getUserId()).isPresent()){
            String pwd = user.getPassword();
            String encodedPwd = encoder.encode(pwd);
            user.setPassword(encodedPwd);
            userRepository.save(user);
            return "user updated successfully";
        }
        else {
            throw new Exception("user does not exist");
        }
    }
    @DeleteMapping("/delete")
    public String deleteUser(@PathVariable String userId)throws Exception{
        if(userRepository.findById(userId).isPresent()){
            userRepository.deleteById(userId);
            return "user deleted successfully";
        }
        else{
            throw new Exception("user does not exist");
        }
    }
    @GetMapping("/{userId}")
    public String getName(@PathVariable String userId){
        return userRepository.findById(userId).get().getUsername();
    }

}
