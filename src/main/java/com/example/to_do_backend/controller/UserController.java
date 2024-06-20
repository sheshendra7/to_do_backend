package com.example.to_do_backend.controller;

import com.example.to_do_backend.entity.User;
import com.example.to_do_backend.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userServiceImp.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return  ResponseEntity.ok(userServiceImp.getByIdUser(id));
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userServiceImp.getAllUsers());
    }

    @PutMapping("/{id}")
    public  ResponseEntity<User> updateUser(@PathVariable("id") Long id,@RequestBody User user){
        return ResponseEntity.ok(userServiceImp.updateUser(id,user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        userServiceImp.deleteUser(id);
        return  ResponseEntity.ok("Deleted User");
    }
}
