package com.kenny.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MethodChecker {
    public Object check(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            long startTime = new Date().getTime();
            Object retuning = proceedingJoinPoint.proceed();
            long endTime = new Date().getTime();
            long duration = endTime - startTime;
            if (duration >= 1000) {
                String className = proceedingJoinPoint.getTarget().getClass().getName();
                String methodName = proceedingJoinPoint.getSignature().getName();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
                String now = simpleDateFormat.format(new Date());
                System.out.println("======" + now + ":" + className + "." + methodName + "(" + duration + "ms)======");
            }
            return retuning;
        } catch (Throwable throwable) {
            System.out.println("Exception message: " + throwable.getMessage());
            throw throwable;
        }
    }
}
