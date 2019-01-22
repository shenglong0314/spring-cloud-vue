package com.glf.parent.provide.system.controller;

import com.glf.parent.provide.system.entity.User;
import com.glf.parent.provide.system.pojo.ResponsePage;
import com.glf.parent.provide.system.service.RolesServiceImpl;
import com.glf.parent.provide.system.service.UserServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Component
@RestController()
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RolesServiceImpl rolesService;

    @GetMapping("/selectUserList")
    public ResponseEntity<ResponsePage> selectUserList(Integer page,Integer limit,String search) {

        ResponsePage responsePage = userService.selectUserList(page, limit,search);
        return ResponseEntity.ok(responsePage);
    }

    @RequestMapping(value = "login")
    public ResponseEntity<Map> login(HttpServletRequest request, @RequestBody Map<String, String> map) {
        if (map.size() != 2) {
            return ResponseEntity.badRequest().build();
        }
        ServletContext servletContext = request.getServletContext();
        HashMap<String, Object> rep = new HashMap<>();
        String username = map.get("username");
        String password = map.get("password");
        User user = userService.login(username, password);
        String token = UUID.randomUUID().toString();
        servletContext.setAttribute(token, user);
        rep.put("token", token);
        return ResponseEntity.ok(rep);
    }

    @RequestMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User user) {
        int i = userService.addUser(user);
        return ResponseEntity.ok(i);
    }
    @RequestMapping("/editUser")
    public ResponseEntity<User> editUser(Long id) {
        User user = userService.editUser(id);
        return ResponseEntity.ok(user);
    }
    @RequestMapping("/deleteUserByid")
    public ResponseEntity deleteUserByid(Integer id){
        int i = userService.deleteUserByid(id);
        return ResponseEntity.ok(i);
    }
    @HystrixCommand(fallbackMethod = "aa")
    @RequestMapping("/findUserByid")
    public ResponseEntity<?> findUserByid(Integer id){
        User user = userService.findUserByid(id);
        return ResponseEntity.ok(user);

    }
    public ResponseEntity<?> aa(Integer id) {
        User user = userService.findUserByid(id);
        return ResponseEntity.ok(11);
    }

    @RequestMapping("/logout")
    public int logout(HttpServletRequest request,String token){
        ServletContext servletContext = request.getServletContext();
        servletContext.removeAttribute(token);

        return 1;
    }
}
