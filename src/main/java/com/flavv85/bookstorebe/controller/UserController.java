package com.flavv85.bookstorebe.controller;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.flavv85.bookstorebe.repository.UserRepository;
import com.flavv85.bookstorebe.model.User;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")
public class UserController {

    public final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // list all users method
    @GetMapping("/get")
    public List<User> getUsers() {
        // return sorted list of users by id
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    // save method
    @PostMapping("/add")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    // delete user
    @DeleteMapping(path = {"/{id}"})
    public User deleteUser(@PathVariable("id") long id) {
        User user = userRepository.getById(id);
        userRepository.deleteById(id);
        return user;
    }
}
