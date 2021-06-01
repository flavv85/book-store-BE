package com.flavv85.bookstorebe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flavv85.bookstorebe.repository.UserRepository;
import com.flavv85.bookstorebe.model.User;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/get")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
