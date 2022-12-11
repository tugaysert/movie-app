package com.example.movieappbackend.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

    @Pointcut("execution(* com.example.movieappbackend.service.*.*(..))")
    public void dataLayerExecution() {

    }

    @Pointcut("execution(* com.example.movieappbackend.service.MovieService.*(..))")
    public void businessLayerExecution() {
    }

    @Pointcut("com.example.movieappbackend.aspect.CommonJoinPointConfig.dataLayerExecution() " +
            "&& com.example.movieappbackend.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public void allLayerExecution() {
    }

    @Pointcut("bean(*Service*)")
    public void beanContainingService(){
    }

    @Pointcut("within(com.example.movieappbackend.service..*)")
    public void businessLayerExecutionWithWithin(){
    }

    @Pointcut("@annotation(com.example.movieappbackend.aspect.TrackTime)")
    public void trackTimeAnnotation(){

    }


}
