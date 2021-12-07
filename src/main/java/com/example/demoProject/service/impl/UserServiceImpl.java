package com.example.demoProject.service.impl;

import com.example.demoProject.dto.UserDto;
import com.example.demoProject.entities.User;
import com.example.demoProject.repos.UserRepository;
import com.example.demoProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public List<User> getAllUsers(UserDto userDto) {
        return userRepository.findAll();
    }

    @Override
    public User saveOneUser(User newUser) {
        //Assert.isNull(newUser.getFirstName(),"REQUIRED");
        return userRepository.save(newUser);
    }

    @Override
    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User user1 = user.get();
            user1.setFirstName(newUser.getFirstName());
            user1.setLastName(newUser.getLastName());
            user1.setPassword(newUser.getPassword());
            user1.setAddresses(newUser.getAddresses());
            userRepository.save(user1);
            return user1;
        } else
            return null;

    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}

