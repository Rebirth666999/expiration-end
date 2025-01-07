package com.pzy.controller;

import com.pzy.entity.User;
import com.pzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        //System.out.printf("进入login函数\n");
        try {
            System.out.println("接收到的用户名: " + user.getUsername());
            User foundUser = userService.findByUsername(user.getUsername());
            if (foundUser != null) {
                System.out.println("找到的用户: " + foundUser.getUsername());
                if (foundUser.getPassword().equals(user.getPassword())) {
                    return ResponseEntity.ok(foundUser);
                } else {
                    System.out.println("密码不匹配");
                    System.out.println("输入的密码: " + user.getPassword());
                    System.out.println("数据库中的密码: " + foundUser.getPassword());
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                }
            } else {
                System.out.println("没有找到该用户");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            e.printStackTrace();  // 打印堆栈跟踪
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            // 检查用户名是否已经存在
            User foundUser = userService.findByUsername(user.getUsername());
            if (foundUser != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("用户名已存在");
            }

            // 保存用户信息
            userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("用户注册成功");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

