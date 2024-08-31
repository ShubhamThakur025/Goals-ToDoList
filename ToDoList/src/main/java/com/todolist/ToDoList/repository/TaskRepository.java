package com.todolist.ToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todolist.ToDoList.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTaskByUserId(Long userId);
}
