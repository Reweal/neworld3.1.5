package org.neworld.springbootmvc.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {
    @Pointcut("execution(* org.neworld.springbootmvc.service.UserService.*(..))")
    public void allServiceMethods() {}
}
