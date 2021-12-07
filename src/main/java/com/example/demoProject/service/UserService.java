package com.example.demoProject.service;

import com.example.demoProject.dto.UserDto;
import com.example.demoProject.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers(UserDto userDto);

    User saveOneUser(User newUser);

    User getOneUserById(Long userId);

    User updateOneUser(Long userId, User newUser);

    void deleteById(Long userId);


}

