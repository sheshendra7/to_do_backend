package com.example.to_do_backend.service;

import com.example.to_do_backend.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task getByIdTask(Long id);
    List<Task> getAllTasks();
    Task updateTask(Long id,Task task);
    void deleteTask(Long id);
}
