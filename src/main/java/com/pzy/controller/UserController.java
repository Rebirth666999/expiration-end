package com.pzy.controller;

import com.alibaba.fastjson.JSON;
import com.pzy.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.pzy.entity.User;

import java.util.List;


@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/listUser")
    @ResponseBody
    @CrossOrigin
    public List<User> listUser() {
        List<User> listUser = userDao.listUserByName("");
        //System.out.println(JSON.toJSONString(listUser));
        return listUser;
    }

    @PostMapping("/selectUser/{name}")
    @ResponseBody
    @CrossOrigin
    public List<User> selectUser(@PathVariable String name) {
        List<User> listUser = userDao.listUserByName(name);
        //System.out.println(JSON.toJSONString(listUser));
        return listUser;
    }

}
