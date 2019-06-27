package com.fhp.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class SystemLogAspect {

    private Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    @Pointcut("execution(* com.fhp.springaop.controller..*.*(..))")
    public void log(){}

    @Before("log()")
    public void before(){
        System.out.println("-----------log before---------------");
    }

    @After("log()")
    public void after(){
        System.out.println("-----------log after---------------");
    }

    @AfterReturning("log()")
    public void afterReturnning(){
        System.out.println("-----------log afterReturnning---------------");
    }

    @Around("log()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("-----------log around start---------------");
        System.out.println(point.getSignature());
        point.proceed();
        System.out.println("-----------log around end---------------");
    }

    @AfterThrowing(pointcut = "log()",throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint,Throwable exception){
        System.err.println(exception.getStackTrace());
        System.err.println(exception.getMessage());

    }
}
