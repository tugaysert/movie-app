package com.example.movieappbackend.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("com.example.movieappbackend.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
    //proceeding joint point would allow you to continue with the execution of the method.
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //startTime = x
        //allow execution of method
        //enTime = y
        long startTime = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;


        logger.info("Time taken by {} is {}", proceedingJoinPoint, timeTaken);
    }

}
