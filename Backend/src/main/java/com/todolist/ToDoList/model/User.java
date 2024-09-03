package com.todolist.ToDoList.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;
}
