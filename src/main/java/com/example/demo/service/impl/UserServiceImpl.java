package com.example.demo.service.impl;


import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncounter;
import org.springframework.stereotype.Service;
import java.util.List;

@Service 
public class UserServiceImpl implements UserService
{
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepo userRepo, PasswordEncounter passwordEncounter)
    {
        this.userRepo=userRepo;
        this.passwordEncounter=passwordEncounter;

    }
    @Override
    public UserEntity registerUser(UserEntity user)
    {
    if(userRepo.existsByEmail(user.getEmail()))
    {
        throw new IllegalArgumentException("Email already exists");
        
    }
    }


}