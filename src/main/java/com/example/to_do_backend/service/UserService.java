package com.example.to_do_backend.service;

import com.example.to_do_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getByIdUser(Long id);
    List<User> getAllUsers();
    User updateUser(Long id,User user);
    void deleteUser(Long id);
}
