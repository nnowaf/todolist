package com.todolist.test.todolist.services;

import com.todolist.test.todolist.dao.UserDao;
import com.todolist.test.todolist.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserDao userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String username, String password, String email) {
        UserDto user = new UserDto();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Hash password
        user.setEmail(email);
        userRepository.save(user);
    }

    public UserDto findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
