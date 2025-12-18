package com.example.demo.service.impl;


import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service 
public class UserServiceImpl implements UserService
{
    private final UserRepo userRepo;
    public UserServiceImpl(UserRepo userRepo) 
    {
        this.userRepo=userRepo;
        

    }
    //method1
    @Override
    public UserEntity registerUser(UserEntity user)
    {
    if(userRepo.existsByEmail(user.getEmail()))
    {
        throw new IllegalArgumentException("Email already exists");
        }
        return userRepo.save(user);
    }
    //method2

    @Override
    public UserEntity getUserById(Long id)
    {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }
    //method3
    
    @Override
    public List<UserEntity> getAllUsers()
    {
        return userRepo.findAll();
    } 
    //method4 

    @Override
    public UserEntity findByEmail(String email)
    {
        return userRepo.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));
    }


}