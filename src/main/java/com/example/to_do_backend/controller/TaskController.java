package com.example.to_do_backend.controller;

import com.example.to_do_backend.entity.Task;
import com.example.to_do_backend.service.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskServiceImp taskServiceImp;

    @PostMapping()
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task savedTask = taskServiceImp.createTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getByIdTask(@PathVariable("id") Long id){
        Task task = taskServiceImp.getByIdTask(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/alltasks")
    public ResponseEntity<List<Task>> getAllTask(){
        return ResponseEntity.ok(taskServiceImp.getAllTasks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long id,@RequestBody Task task){
        Task updatedTask = taskServiceImp.updateTask(id,task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id){
        taskServiceImp.deleteTask(id);
        return ResponseEntity.ok("Task Deleted");
    }
}
