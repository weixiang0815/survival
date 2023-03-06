package tw.survival.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import tw.survival.model.Player.PlayerBean;


@SessionAttributes({"employee","player"})
public class MyAspect {
		
	@Autowired
    private HttpSession session;
	
	@Before("execution(* tw.survival.controller.*(..)) && !execution(* tw.survival.controller.Login_Logout.*(..))")
	public RedirectView before(JoinPoint joinPoint) {
        // 取得目前使用者的登入資訊，例如從 session 取得使用者物件
		PlayerBean player = (PlayerBean) session.getAttribute("player");
		System.out.println("執行AOP>>>>>>>>>>>>>>>>");
        // 如果使用者未登入，拋出 UnauthorizedException
        if (player == null) {
        	return new RedirectView("/back/loginSystem");
        }
		return null;
    }


}
