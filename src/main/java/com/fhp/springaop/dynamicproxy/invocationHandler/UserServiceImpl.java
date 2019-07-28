package com.fhp.springaop.dynamicproxy.invocationHandler;

public class UserServiceImpl implements IUserService {

    @Override
    public void sayHello() {
        System.out.println("sayHello called");
    }

    @Override
    public String getUser() {
        System.out.println("getUser called");
        return null;
    }
}
