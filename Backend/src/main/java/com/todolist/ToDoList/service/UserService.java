package com.todolist.ToDoList.service;

import com.todolist.ToDoList.model.User;
import com.todolist.ToDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
