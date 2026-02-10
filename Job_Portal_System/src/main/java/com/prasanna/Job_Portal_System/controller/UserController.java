package com.prasanna.Job_Portal_System.controller;


import com.prasanna.Job_Portal_System.entity.User;
import com.prasanna.Job_Portal_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User savedUser = userService.registerUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginDetails){
        User user = userService.findByUsername(loginDetails.getUsername());
        if(passwordEncoder.matches(loginDetails.getPassword(), user.getPassword())){
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
        }
    }

    @PostMapping("/verify/{id}")
    public ResponseEntity<String> verifyEmployer(@PathVariable Long id){
        userService.verifyEmployer(id);
        return ResponseEntity.ok("Employer verified successfully!");
    }
}
