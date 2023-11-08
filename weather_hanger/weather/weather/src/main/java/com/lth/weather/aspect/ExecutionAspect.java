package com.lth.weather.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class ExecutionAspect {

//    配置切入点
    @Pointcut("@annotation(com.lth.weather.aspect.ExecutionTarget)")
    public void ExecutionTarget(){}

//    配置前置增强
    @Before("ExecutionTarget()")
    public void enhanceTarget(){
        System.out.println("我增强了你！前置哦");
    }

//    配置后置增强
    @After("ExecutionTarget()")
    public void enhanceAfter(){
        System.out.println("我是after增强");
    }

//    后置二
    @AfterReturning("ExecutionTarget()")
    public void enhanceAfterRun(){
        System.out.println("我是afterRun增强");
    }

    @AfterThrowing("execution(* com.wang.weather.controller..UserController.*(..))")
    public void throwEnhance(){
        System.out.println("抛出异常了，我来帮你！");
    }
}
