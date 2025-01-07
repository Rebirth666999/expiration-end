package com.pzy.service;

import com.pzy.entity.User;
import com.pzy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void registerUser(User user) {
        // 直接保存用户信息，不进行任何密码加密
        userRepository.save(user);
    }
}
