package com.example.creditcenter.Dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import java.lang.reflect.Method;

/**
 * @param
 * @param
 * @description: 对自定义的注解类进行切面控制
 * @return:
 * @author: liufangyuan
 * @date: 2020/07/05
*/

@Aspect
public class DataSourceAspect {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DataSourceAspect.class);

    @Pointcut("@annotation(ChoseDataSource)")
    public void setDatasource(){
    }

    @Before("setDatasource()")
    public void before(JoinPoint point){
        MethodSignature methodSignature =  (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        ChoseDataSource annotation = method.getAnnotation(ChoseDataSource.class);
        String value = annotation.value();
        DbContextHolder.setDataSource(value);
        log.error(value);
        //System.out.println("enter before");
    }

    /**
     *自定义注解的切面范围after在注解之后但是是在
     * Audit selectAuditById(Integer id);方法之前执行的
     *
     */
    @After("setDatasource()")
    public void after(){
        //System.out.println("clear after");
        //DbContextHolder.clearDataSource();
    }

    @Around("setDatasource()")
    public void around(){

    }
}
