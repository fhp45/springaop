package com.fhp.springaop.dynamicproxy.invocationHandler;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

    private Object realObject;

    public MyHandler(Object o) {
        this.realObject = o;
    }

    @Override
    public Object invoke(Object aspect, Method method, Object[] args) throws Throwable {
        Method[] methods = aspect.getClass().getDeclaredMethods();
        //执行@Before的增强
        for (Method method1 : methods) {
            if (method1.isAnnotationPresent(Before.class)) {
                method1.invoke(aspect, null);
            }
        }
        method.invoke(realObject, args);
        //执行@After的增强
        for (Method method1 : methods) {
            if (method1.isAnnotationPresent(After.class)) {
                method1.invoke(aspect, null);
            }
        }
        return null;
    }
}
