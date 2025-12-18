package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import java.util.List;


public interface UserService
{
    UserEntity registerUser(UserEntity user);
    UserEntity getUserById(Long id);
    List<UserEntity> getAllUsers();
    UserEntity findByEmail(String Mail);
    
}