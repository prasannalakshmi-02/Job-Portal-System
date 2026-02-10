package com.prasanna.Job_Portal_System.service;

import com.prasanna.Job_Portal_System.entity.User;
import com.prasanna.Job_Portal_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String email) {

        return userRepository.findByUsername(email)
                .orElseThrow(()->new UsernameNotFoundException("User is not found"));
    }

    @Override
    public void verifyEmployer(Long employerId) {
         User employer = userRepository.findById(employerId)
                 .orElseThrow(()->new RuntimeException("Employer not found with id"+ employerId));
         employer.setVerified(true);
         userRepository.save(employer);

    }
}
