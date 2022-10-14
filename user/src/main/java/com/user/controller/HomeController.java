package com.user.controller;

import com.user.model.User;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/secure")
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/home")
    public String home(){
        return "Welcome to home page";
    }
    @GetMapping("/get")
    public ResponseEntity<List<User>>getAllUser(){
        return ResponseEntity.ok(userRepository.findAll());
    }
}
