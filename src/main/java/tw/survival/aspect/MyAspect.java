package tw.survival.aspect;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Aspect 標註為一個切面程式，用來達成「橫切關注」（cross-cutting concerns）功能的其中之一。<br>
 *         例如：日誌記錄、安全性、事務管理、快取、性能優化等。<br>
 *         這些功能與系統的主要業務邏輯通常是分離的，但是它們又必須被整個系統所使用。<br>
 *         建議與 @Controller 分開，因此以下程式用不到 @Controller 注釋。
 */
@SessionAttributes({ "employee", "player" })
@Aspect
@Component
public class MyAspect {

	/**
	 * 設定 AOP 橫切關注的範圍（前台頁面必須登入會員的 Controller），但不限制未登入使用者查詢（R）資料
	 */
	@Pointcut(" execution(* tw.survival.controller.front.CUD..*(..)) ")
	public void pointcutFront() {
	}

	/**
	 * 設定 AOP 橫切關注的範圍（後台頁面的 Controller）
	 */
	@Pointcut(" execution(* tw.survival.controller.back..*(..)) ")
	public void pointcutBack() {
	}

	/**
	 * 如果使用者（player）未登入而進入被限制的區域，重新導向使用者登入頁面。
	 * 
	 * @param joinPoint 用此物件的方法得知正在使用的 Controller 方法名稱
	 * @throws IOException
	 * @author 王威翔
	 * @author 鄭力豪
	 */
	@Before("pointcutFront()")
	public void beforeFront(JoinPoint joinPoint) throws IOException {

		// 使用 ServletRequestAttributes 的靜態方法取得 HttpServletRequest 以及 HttpServletResponse
		// 來實作重導頁面。
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		HttpServletResponse response = attributes.getResponse();

		// 取得目前使用者的登入資訊，例如從 session 取得使用者物件
		HttpSession session = request.getSession(false);

		// 在 Console 可以看到甚麼時間點執行了 AOP before 方法
		System.out.println("=====before advice starts=====");

		// joinPoint.getSignature().getName() 可以知道程式正在使用的 API 是哪一個
		System.out.println("Before method execution: " + joinPoint.getSignature().getName());
		System.out.println(session);
		System.out.println(session.getAttribute("player"));
		// 如果使用者未登入，重導至登入頁面。
		if (session == null || session.getAttribute("player") == null) {
			System.out.println("權限不足，需要登入");
			System.out.println("player.nonLogin");
			response.sendRedirect(request.getContextPath() + "/Player/login");
			return;
		}
//		if(session ==null||session.getAttribute("employee")==null) {
//			System.out.println("權限不足，需要登入");
//			response.sendRedirect(request.getContextPath() + "/Employee/login");
//			return;
//		}else if(session!=null||session.getAttribute("employee")!=null){
//			response.sendRedirect(request.getContextPath()+"/Employee/index");
//		}
	}

	/**
	 * 如果員工（employee）未登入而進入被限制的區域，重新導向員工登入頁面。
	 * 
	 * @param joinPoint 用此物件的方法得知正在使用的 Controller 方法名稱
	 * @throws IOException
	 * @author 王威翔
	 * @author 鄭力豪
	 */
	@Before("pointcutBack()")
	public void beforeBack(JoinPoint joinPoint) throws IOException {

		// 使用 ServletRequestAttributes 的靜態方法取得 HttpServletRequest 以及 HttpServletResponse
		// 來實作重導頁面。
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		HttpServletResponse response = attributes.getResponse();

		// 取得目前使用者的登入資訊，例如從 session 取得使用者物件
		HttpSession session = request.getSession(false);

		// 在 Console 可以看到甚麼時間點執行了 AOP before 方法
		System.out.println("=====before advice starts=====");

		// joinPoint.getSignature().getName() 可以知道程式正在使用的 API 是哪一個
		System.out.println("Before method execution: " + joinPoint.getSignature().getName());

		// 如果員工未登入，重導至登入頁面。
		if (session == null || session.getAttribute("employee") == null) {
			System.out.println("權限不足，需要登入");
			System.out.println("employee.nonLogin");
			response.sendRedirect(request.getContextPath() + "/Employee/login");
			return;
		}
	}

}