package com.example.to_do_backend.service;

import com.example.to_do_backend.entity.Task;
import com.example.to_do_backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService{

    @Autowired
    private final TaskRepository taskRepository;

    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {

        return taskRepository.save(task);
    }

    @Override
    public Task getByIdTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found Task"+id)
        );
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task newTask = taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found"+id)
        );
        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        newTask.setCompleted(task.getCompleted());
        taskRepository.save(newTask);
        return newTask;
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found Task"+id)
        );
        taskRepository.deleteById(id);
    }
}
