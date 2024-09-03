package com.todolist.ToDoList.repository;

import com.todolist.ToDoList.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> findUserByUsername(String username);
}
