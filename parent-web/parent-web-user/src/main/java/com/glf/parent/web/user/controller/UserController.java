package com.glf.parent.web.user.controller;


import com.glf.parent.provide.system.entity.User;
import com.glf.parent.web.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("selectUserList")
    ResponseEntity<List<User>> selectUserList(){

        List<User> users = userService.selectUserList();
        return ResponseEntity.ok(users);

    }
    @RequestMapping("/findUserByid")
    public User findUserByid(){

        User user = userService.findUserByid(1);
        return user;
    }

}
