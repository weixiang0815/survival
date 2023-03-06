package tw.survival.aspect;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@SessionAttributes({ "employee", "player" })
@Aspect
@Controller
public class MyAspect {

	@Pointcut("execution(* tw.survival.controller..*(..)) " + "&& !execution(* tw.survival.controller.global..*(..)) "
			+ "&& !execution(* tw.survival.controller.login_logout..*(..))")
	public void pointcut() {
	}

	@SuppressWarnings("null")
	@Before("pointcut()")
	public void before(JoinPoint joinPoint) throws IOException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		HttpSession session = request.getSession(false);
		// 取得目前使用者的登入資訊，例如從 session 取得使用者物件
		System.out.println("=====before advice starts=====");
		System.out.println("Before method execution: " + joinPoint.getSignature().getName());
		// 如果使用者未登入，拋出 UnauthorizedException
		if (session == null || session.getAttribute("player") == null) {
			System.out.println("權限不足，需要登入");
			response.sendRedirect(request.getContextPath() + "/Player/login");
		}
	}

}