package com.mrxiaozhu.springbootmybatis01.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DesensitizationAspect {
//    @Around(value = "(execution(* com.ppd.ayokreditbackend.controller..*(..)))")
    @AfterReturning(value = "(execution(* com.mrxiaozhu.springbootmybatis01.controller..*(..)))")
    @Around(value = "(execution(* com.ppd.ayokreditbackend.controller..*(..))) && !@annotation(com.ppd.ayokreditbackend.web.DisableAuditLog) && (@annotation(org.springframework.web.bind.annotation.RequestMapping) || @annotation(org.springframework.web.bind.annotation.GetMapping) || @annotation(org.springframework.web.bind.annotation.PostMapping) || @annotation(org.springframework.web.bind.annotation.PutMapping))")
    public Object methodAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("拦截到了。。。。。");
        return null;
    }
}
