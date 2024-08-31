package com.todolist.ToDoList.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ISCOMPLETED")
    private boolean isCompleted;
    private LocalDate dueDate;

    @ManyToOne //defines the many-to-one relationship
    @JoinColumn(name = "user_id") //sets the column name to be user_id
    private User user;
}
