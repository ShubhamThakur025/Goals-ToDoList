package com.todolist.ToDoList.controller;

import com.todolist.ToDoList.dto.LoginRequest;
import com.todolist.ToDoList.model.User;
import com.todolist.ToDoList.security.JwtHelper;
import com.todolist.ToDoList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtHelper jwtHelper;


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        try {
            UserDetails userDetails = userService.loadUserByUsername(username);
            if (passwordEncoder.matches(password, userDetails.getPassword())) {
                String jwtToken = jwtHelper.generateToken(userDetails);
                return ResponseEntity.ok(jwtToken);
            } else {
                return ResponseEntity.status(401).body("Invalid Credentials");
            }
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }
}
