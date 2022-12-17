package com.example.movieappbackend.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect //combination of pointcut and advice
@Configuration
public class MovieAccessAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //inside the execution -> pointcut
    @Before("com.example.movieappbackend.aspect.CommonJoinPointConfig.dataLayerExecution()")
    //joinpoint -> specific execution instance, interception.
    public void before(JoinPoint joinPoint) {
        //inside the body -> advice
        logger.info("Check for user access ");
        logger.info("Intercepted Method Calls - {}", joinPoint);
    }

    @AfterReturning(
            value = "execution(* com.example.movieappbackend.service.*.*(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("{} returned with value {}", joinPoint, result);
    }

    @AfterThrowing(
            value = "execution(* com.example.movieappbackend.service.*.*(..))",
            throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.info("{} throw exception {}", joinPoint, exception);
    }

    @After(
            value = "execution(* com.example.movieappbackend.service.*.*(..))"
            )
    public void after(JoinPoint joinPoint ) {

        logger.info("after execution of {}", joinPoint);
    }
}
