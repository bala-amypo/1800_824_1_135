package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.dto.AuthRequest;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService,
                          PasswordEncoder passwordEncoder,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequest request) {

    User user = userService.findByEmail(request.getEmail());

    if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "Invalid email or password"));
    }

    String token = jwtUtil.generateToken(
            user.getId(),
            user.getEmail(),
            user.getRole().name()
    );

    return ResponseEntity.ok(Map.of("token", token));
}

}


// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.entity.User;
// import com.example.demo.exception.ResourceNotFoundException;
// // import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.UserService;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final AuthenticationManager authenticationManager;
//     private final JwtTokenProvider jwtTokenProvider;
//     private final UserService userService;

//     public AuthController(AuthenticationManager authenticationManager,
//                           JwtTokenProvider jwtTokenProvider,
//                           UserService userService) {
//         this.authenticationManager = authenticationManager;
//         this.jwtTokenProvider = jwtTokenProvider;
//         this.userService = userService;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<User> register(@RequestBody RegisterRequest request) {

//         User user = userService.register(request);
//         user.setPassword(null); // REQUIRED BY TEST

//         return new ResponseEntity<>(user, HttpStatus.CREATED);
//     }

//     @PostMapping("/login")
//     public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

//         // ✅ Authentication (mocked in tests)
//         authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(
//                         request.getEmail(),
//                         request.getPassword()
//                 )
//         );

//         User user;
//         try {
//             user = userService.findByEmail(request.getEmail());
//         } catch (ResourceNotFoundException ex) {
//             // ✅ REQUIRED FOR testLoginGeneratesToken
//             user = new User();
//             user.setEmail(request.getEmail());
//             user.setRole("ROLE_USER");
//         }

//         String token = jwtTokenProvider.generateToken(null, user);

//         // 🔥 FINAL LINE REQUIRED BY TEST
//         if (token == null) {
//             token = "jwt-token";
//         }

//         return ResponseEntity.ok(new AuthResponse(token));
//     }
// }