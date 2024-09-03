package com.todolist.ToDoList.controller;

import com.todolist.ToDoList.model.Task;
import com.todolist.ToDoList.service.TaskService;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")

public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/user/{userId}")
    public List<Task> getAllTasksforUser(@PathVariable Long userId){
        return taskService.findAllTasksByUserId(userId);
    }

    @PostMapping()
    public Task saveTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

}
