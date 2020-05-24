package com.cg.employeemanagementservice.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 02:43
 */

/**
 * Used for custom l;ogging
 * Uses the concept of AOP
 */
@Aspect
@Slf4j
@Component
public class CustomLogger {


    /**
     * Specifies where will certain operation be carried out
     */
    @Pointcut("execution(* com.cg.*.*.*.*(..)))")
    public void everyWhere() {}

    /**
     * The advice To be executed
     */
    @Before("everyWhere()")
    public void logBefore(JoinPoint point) {
        log.debug("@Before class: " + point.getTarget().getClass().getSimpleName());
        log.debug("@Before method: " + point.getSignature().toShortString());
        log.info("Arguments: ");
        Object[] objects = point.getArgs();
        for (Object object : objects) {
            System.out.println("->" + object);
        }
    }

    /**
     * The advice to be executed
     */
    @AfterReturning(pointcut = "everyWhere()", returning = "result")
    public void logAfter(JoinPoint point, Object result) {
        log.debug("@AfterReturning class: " + point.getTarget().getClass().getSimpleName());
        log.debug("@AfterReturning method: " + point.getSignature().toShortString());
        log.debug("Returning Value: " + result);
    }

}
