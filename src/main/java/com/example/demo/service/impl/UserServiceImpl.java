package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // ✅ Constructor EXACTLY as tests expect
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ TEST EXPECTS: register(User)
    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    // ✅ TEST EXPECTS: getById(Long)
    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // ✅ Used in tests
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ Used in tests
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
