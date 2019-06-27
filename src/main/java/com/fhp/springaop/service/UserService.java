package com.fhp.springaop.service;


import com.fhp.springaop.domain.User;
import com.fhp.springaop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(int id){
        return userMapper.findById(id);
    }

    public void insertUser(User user){
        userMapper.insert(user);
    }
}
