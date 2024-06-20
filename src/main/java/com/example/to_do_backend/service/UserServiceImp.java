package com.example.to_do_backend.service;

import com.example.to_do_backend.entity.User;
import com.example.to_do_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getByIdUser(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found User"+id)
        );
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        User newUser = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found User"+id)
        );
        newUser.setUserName(user.getUserName());
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setRole(user.getRole());
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found User"+id)
        );
        userRepository.deleteById(id);
    }
}
