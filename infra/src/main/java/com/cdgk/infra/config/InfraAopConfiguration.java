package com.cdgk.infra.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class InfraAopConfiguration {

    /**
     * Pointcut for execution of methods on {@link Controller} annotation
     */
    @Pointcut("execution(public * (@org.springframework.stereotype.Controller com.cdgk..*).*(..))")
    public void restAnnotation() {
        // AOP for Rest Anotation : Controller
    }

    @Pointcut("execution(public * (@org.springframework.web.bind.annotation.RestController com.cdgk..*).*(..))")
    public void restAnnotation2() {
        // AOP for Rest Anotation : RestController
    }

    /**
     * Pointcut for execution of methods on {@link Service} annotation
     */
    @Pointcut("execution(public * (@org.springframework.stereotype.Service com.cdgk..*).*(..))")
    public void serviceAnnotation() {
        // AOP for Service Anotation : Service
    }

    /**
     * Pointcut for execution of methods on {@link Repository} annotation
     */
    @Pointcut("execution(public * (@org.springframework.stereotype.Repository com.cdgk..*).*(..))")
    public void repositoryAnnotation() {
        // AOP for Repository Anotation : Repository
    }

    /**
     * Pointcut for execution of methods on {@link JpaRepository} interfaces
     */
    @Pointcut("execution(public * org.springframework.data.jpa.repository.JpaRepository+.*(..))")
    public void jpaRepository() {
        // AOP for JpaRepository Anotation : JpaRepository
    }

    @Pointcut("restAnnotation() || restAnnotation2() ||serviceAnnotation() || repositoryAnnotation() || jpaRepository()")
    public void performanceMonitor() {
        // AOP performance Monitor
    }

    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
        return new PerformanceMonitorInterceptor(false);
    }

    @Bean
    public Advisor performanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.cdgk.infra.config.InfraAopConfiguration.performanceMonitor()");
        return new DefaultPointcutAdvisor(pointcut, performanceMonitorInterceptor());
    }
}