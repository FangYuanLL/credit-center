package com.example.creditcenter.Dao;

import org.aspectj.lang.JoinPoint;
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
        System.out.println(value);
    }
}
