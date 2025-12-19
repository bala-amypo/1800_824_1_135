package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;


public interface UserService
{
    UserEntity registerUser(UserEntity user);
    UserEntity getUserById(Long id);
    List<UserEntity> getAllUsers();
    UserEntity findByEmail(String email);
    
}