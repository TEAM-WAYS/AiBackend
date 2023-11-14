package com.example.backendai.controller;
import com.example.backendai.model.Recipe;
import com.example.backendai.model.User;
import com.example.backendai.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("users")
        public ResponseEntity<List<User>> getAllUser() {
        List<User> userList = userRepository.findAll();
        //  return userRepository.findAll();
            if (userList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userList);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(userList);
            }
        }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userRepository.findById(id);
    }
    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok("User created successfully");
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
       User existingUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return "success";
        } else {
            return "failure";
        }

    }
}



