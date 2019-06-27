package com.fhp.springaop.controller;


import com.fhp.springaop.domain.User;
import com.fhp.springaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public User queryUserById(@PathVariable("id") int id) {
        User user =  userService.queryById(id);
        System.out.println(user);
        return user;
    }

    @RequestMapping("/insert")
    public User insert(@RequestBody User user){
        userService.insertUser(user);
        return userService.queryById(user.getId());
    }
}
