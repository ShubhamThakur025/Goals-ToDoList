package com.todolist.ToDoList.service;

import com.todolist.ToDoList.model.Task;
import com.todolist.ToDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.*;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<Task> findAllTasksByUserId(Long id){
        return taskRepository.findTaskByUserId(id);
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }
}
