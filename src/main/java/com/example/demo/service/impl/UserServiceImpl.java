// package com.example.demo.service.impl;

// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import org.springframework.stereotype.Service;
// import java.util.List;


// @Service 
// public class UserServiceImpl implements UserService
// {
//     private final UserRepository userRepo;
//     public UserServiceImpl(UserRepository userRepo) 
//     {
//         this.userRepo=userRepo;
//     }
//     //method1
//     @Override
//     public User registerUser(User user)
//     {
//     if(userRepo.existsByEmail(user.getEmail()))
//     {
//         throw new IllegalArgumentException("Email already exists");
//     }
//         return userRepo.save(user);
//     }
//     //method2

//     @Override
//     public User getUserById(Long id)
//     {
//         return userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
//     }
//     //method3
    
//     @Override
//     public List<User> getAllUsers()
//     {
//         return userRepo.findAll();
//     } 
//     //method4 

//     @Override
//     public User findByEmail(String email)
//     {
//         return userRepo.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));
//     }


// }
// package com.example.demo.service.impl;

// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;

// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;

//     // ✅ Constructor EXACTLY as tests expect
//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     // ✅ TEST EXPECTS: register(User)
//     @Override
//     public User register(User user) {
//         return userRepository.save(user);
//     }

//     // ✅ TEST EXPECTS: getById(Long)
//     @Override
//     public User getById(Long id) {
//         return userRepository.findById(id).orElse(null);
//     }

//     // ✅ Used in tests
//     @Override
//     public List<User> getAllUsers() {
//         return userRepository.findAll();
//     }

//     // ✅ Used in tests
//     @Override
//     public User findByEmail(String email) {
//         return userRepository.findByEmail(email).orElse(null);
//     }
// }
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
