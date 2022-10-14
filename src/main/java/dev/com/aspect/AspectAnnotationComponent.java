package dev.com.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAnnotationComponent {

    //环绕通知。
    //注意要有ProceedingJoinPoint参数传入。
    //execution配置规则    首先是:包名  然后是: 类名  然后是方法名:方法名   括号内是:参数
    //调用controller包下的任意类的任意方法时均会调用此方法 (注意：如果找不到 会提示显示红色)
    //@Around("execution(* com.controller.*.*(..))")
//    @Around("execution(* com.example.demo.aspect.AspectTest.aspectMethodTestOne(..))")

    @Around("execution(* dev.com.controller.OrderController.getOrder(..))")
    public Object sayAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知前。。");
        Object result =proceedingJoinPoint.proceed();
        System.out.println("环绕通知后。。");
        return result;
    }

    //定义切点
    @Pointcut("execution(* dev.com.controller.OrderController.getOrderById(..))")
    public void sayings(){
    }

    @Before("sayings()")
    public void sayHello(){
        System.out.println("注解类型 @Pointcut 前置通知");
    }
    //后置通知
    @After("sayings()")
    public void sayGoodbey(){
        System.out.println("注解类型 @Pointcut 后置通知");
    }
}
