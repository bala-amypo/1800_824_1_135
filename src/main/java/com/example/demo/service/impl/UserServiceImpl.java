package com.example.demo.service.impl;


import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.lang.RuntimeException


@Service 
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepo;
    public UserServiceImpl(UserRepository userRepo) 
    {
        this.userRepo=userRepo;
        

    }
    //method1
    @Override
    public User registerUser(User user)
    {
    if(userRepo.existsByEmail(user.getEmail()))
    {
        throw new IllegalArgumentException("Email already exists");
        }
        return userRepo.save(user);
    }
    //method2

    @Override
    public User getUserById(Long id)
    {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }
    //method3
    
    @Override
    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    } 
    //method4 

    @Override
    public User findByEmail(String email)
    {
        return userRepo.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));
    }


}