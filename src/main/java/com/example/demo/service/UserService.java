// package com.example.demo.service;

// import com.example.demo.entity.User;
// import java.util.List;


// public interface UserService
// {
//     User registerUser(User user);
//     User getUserById(Long id);
//     List<User> getAllUsers();
//     User findByEmail(String email);
    
// }
 package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {

    User register(User user);

    User getById(Long id);

    List<User> getAllUsers();

    User findByEmail(String email);
}
