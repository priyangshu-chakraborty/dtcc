package com.example.demo1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.model.User;
import com.example.demo1.repo.UserRepo;
import com.example.demo1.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")

public class ApiController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (userService.validateUser(username, password)) {
            return "Login successful!";
        } else {
            return "Invalid username or password.";
        }
    }

    @GetMapping("/")
    public String giveString() {
        return "Welcome back";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/save")
    public String saveUser(User user) {
        return null;

    }
}
