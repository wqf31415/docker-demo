package xyz.wqf.dockerdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import xyz.wqf.dockerdemo.annotation.AnnoAspect;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2020/7/1.
 *
 * @author WeiQuanfu
 */
@Aspect
public class CustomAspect {
    @Pointcut(value = "within(xyz.wqf.dockerdemo.service.UserService) || @annotation(xyz.wqf.dockerdemo.annotation.AnnoAspect))")
    public void customPointcut(){

    }

    @Before("customPointcut()")
    public void customBefore(JoinPoint joinPoint){
        System.out.println("前置通知: "+joinPoint.getSignature());
    }

    @Around("customPointcut()")
    public Object customAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知: "+joinPoint.getSignature());
        try {
            Object result = joinPoint.proceed();
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }
    }

    @After("customPointcut()")
    public void customAfter(JoinPoint joinPoint){
        System.out.println("后置通知: "+joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "customPointcut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result) throws Throwable {
        System.out.println("返回通知: "+joinPoint.getSignature());
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        AnnoAspect anno = method.getAnnotation(AnnoAspect.class);
        if (anno != null){
            System.out.println("数据类型：" + anno.value());
        }
        System.out.println(result);
    }

    @AfterThrowing(pointcut = "customPointcut()",throwing = "e")
    public void customThrow(JoinPoint joinPoint, Throwable e){
        System.out.println("出错通知: "+joinPoint.getSignature());
    }
}
