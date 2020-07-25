package com.crystal.SpringBootPractise.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogAop {
   /* @Pointcut(value = "(within(com.crystal.example..*))")
    public void pointCut1(){}*/

    @Pointcut(value = "@annotation(com.crystal.SpringBootPractise.aop.AddLog)")
    public void pointCut(){}


    @Around("pointCut()&&@annotation(addLog)")
    public Object Around(ProceedingJoinPoint joinPoint,AddLog addLog) throws Throwable {
      log.info("在方法调用前执行的切面方法");
         Object obj = joinPoint.proceed();
        log.info("方法调用之后执行:{}",addLog.comment());
        return obj;

    }
}
