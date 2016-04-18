package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by alex on 05/04/2016.
 */
@Aspect
public class LogAspect {

    @Before("execution(* com.example.controller.TournamentController.addTournament())")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("Before");
        System.out.println("Method : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    @After("execution(* com.example.controller.UserController.getUsers())")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println("After");
        System.out.println("Method : " + joinPoint.getSignature().getName());
        System.out.println("******");

    }
}
