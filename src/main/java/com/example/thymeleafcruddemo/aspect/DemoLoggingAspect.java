package com.example.thymeleafcruddemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Aspect
@Component
public class DemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.example.thymeleafcruddemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.example.thymeleafcruddemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.example.thymeleafcruddemo.repository.*.*(..))")
    private void forRepositoryPackage() {}

    // combine
    @Pointcut("forControllerPackage() || forServicePackage() || forRepositoryPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before (JoinPoint joinPoint){

        // display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("=======>> in @Before: calling method: " + method);

        // display the arguments to the method

        // get the arguments
        Object[] args = joinPoint.getArgs();

        // loop through the arguments
        for (Object tmpArg : args){
            logger.info("======>> argument: " + tmpArg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result){

        // display method we are returning from
        String method = joinPoint.getSignature().toShortString();
        logger.info("=======>> in @AfterReturning: calling method: " + method);

        // display the data
        logger.info("=======>> result: " + result);
    }

}
