package com.prasanna.Job_Portal_System.service;

import com.prasanna.Job_Portal_System.entity.User;

public interface UserService {

    User registerUser(User user);

    User findByUsername(String email);

    void verifyEmployer(Long employerId);
}
