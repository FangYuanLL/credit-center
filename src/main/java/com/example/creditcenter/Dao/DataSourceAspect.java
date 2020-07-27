package com.example.creditcenter.Dao;

import com.example.creditcenter.Model.Audit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
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
@Component
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

    //将doAround方法的返回值改成和切点方法返回值类型一样就不会报错？？？？？？？
    //Around的切面返回值是，SelectById获取到的值，也就是切面影响到了实际方法的返回值
    @Around("setDatasource()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("before proceed");
        Object[] args = point.getArgs();
        Object o = point.proceed(args);
        DbContextHolder.clearDataSource();
        System.out.println("after preceed");
        return o;
    }
}
