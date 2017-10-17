package edu.mum;

import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Component
@org.aspectj.lang.annotation.Aspect
public class LoggerAspect {
    
    //Note:
     @Pointcut("execution(* edu.mum.service..*(..))")
           public void applicationMethod() {}


          @Before("applicationMethod()")
          public void logResource(JoinPoint joinPoint) {
         
                    System.out.println( "   **********     TARGET CLASS : " + 
                    joinPoint.getSignature().getDeclaringTypeName() + "." +
                    joinPoint.getSignature().getName() + 
                                        "    **********");
      }

}