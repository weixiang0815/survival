package tw.survival.aspect;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


//@Aspect : 標註為一個切面程式，用來達成 橫切關注（cross-cutting concerns） 功能的其中之一。例如:日誌記錄、安全性、事務管理、緩存、性能優化等。
//這些功能與系統的主要業務邏輯通常是分離的，但是它們又必須被整個系統所使用。 建議與@Controller分開。
//因此以下程式用不到@Controller注釋。
@SessionAttributes({ "employee", "player" })
@Aspect 
public class MyAspect {
	
	//設定AOP橫切關注的範圍
	@Pointcut(" execution(* tw.survival.controller..*(..)) "
			+ " && !execution(* tw.survival.controller.global..*(..)) "
			+ " && !execution(* tw.survival.controller.login_logout..*(..)) ")
	public void pointcut() {
	}

	@SuppressWarnings("null")
	@Before("pointcut()")
	public void before(JoinPoint joinPoint) throws IOException {
		
		//使用 ServletRequestAttributes 的靜態方法取得 HttpServletRequest 以及 HttpServletResponse 來實作重導頁面。
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		HttpServletResponse response = attributes.getResponse();
		
		// 取得目前使用者的登入資訊，例如從 session 取得使用者物件
		HttpSession session = request.getSession(false);
		
		//在Console可以看到甚麼時間點執行了AOP before方法
		System.out.println("=====before advice starts=====");
		
		//joinPoint.getSignature().getName() 可以知道程式這在使用的API是哪一個 
		System.out.println("Before method execution: " + joinPoint.getSignature().getName());
		
		// 如果使用者未登入，重導至登入頁面。
		if (session == null || session.getAttribute("player") == null) {
			System.out.println("權限不足，需要登入");
			response.sendRedirect(request.getContextPath() + "/Player/login");
			return;
		}
	}

}