package com.fhp.springaop.dynamicproxy.invocationHandler;

import com.fhp.springaop.aspect.SystemLogAspect;

import java.lang.reflect.Method;

public class MainTest {

    public static void main(String[] args) throws Throwable {
        IUserService userService = new UserServiceImpl();
        MyHandler myHandler = new MyHandler(userService);

        SystemLogAspect systemLogAspect = new SystemLogAspect();

        Method method = userService.getClass().getMethod("sayHello",null);
        myHandler.invoke(systemLogAspect,method,null);
    }
}
