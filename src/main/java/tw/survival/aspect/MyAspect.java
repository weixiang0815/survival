package tw.survival.aspect;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;



@SessionAttributes({"employee","player"})
@Aspect
@Controller
public class MyAspect {
		
	
	
	@Pointcut("execution(* tw.survival.service..*(..))")
    public void pointcut() {
    }
	
	@Before("pointcut()")
	public void before(JoinPoint joinPoint) {
        // 取得目前使用者的登入資訊，例如從 session 取得使用者物件
		System.out.println("=====before advice starts=====");
		System.out.println("Before method execution: " + joinPoint.getSignature().getName());
        // 如果使用者未登入，拋出 UnauthorizedException
		return;
    }


}
