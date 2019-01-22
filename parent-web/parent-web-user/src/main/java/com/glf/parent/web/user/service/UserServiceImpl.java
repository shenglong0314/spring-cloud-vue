package com.glf.parent.web.user.service;



import com.glf.parent.provide.system.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;




//@FeignClient(value="SYSTEM-PRIVATE")
@FeignClient("ZUUL")
public interface UserServiceImpl {


    @RequestMapping(value="/user/selectUserList",method = RequestMethod.GET)
     List<User> selectUserList();
     @RequestMapping(value="/user/login",method = RequestMethod.POST)
     User login(@RequestParam String name, @RequestParam String password);
    @RequestMapping(value="/user/user/findUserByid",method = RequestMethod.GET)
     User findUserByid(@RequestParam Integer id);
    @RequestMapping(value="/user/user/findUserByid",method = RequestMethod.GET)
     ClientDetails loadClientByClientId(String clientId);
}
