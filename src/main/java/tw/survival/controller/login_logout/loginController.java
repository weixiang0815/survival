package tw.survival.controller.login_logout;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.survival.model.Player.PlayerBean;
import tw.survival.service.login_logout.login_logoutService;

@Controller
public class loginController {

	@Autowired
	public login_logoutService service;

	@GetMapping("/Player/login")
	public String login() {
		return "Player/loginSystem";
	}

	@PostMapping("/Player/loginSystem")
	public String checklog(@RequestParam("account") String account, @RequestParam("password") String password,
			HttpSession session) {
		PlayerBean player = service.login(account, password);
		if (player != null) {
			session.setAttribute("player", player);
			return "Player/loginSuccess";
		}
		return "Player/loginSystem";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("player", null);
		return "redirect:/Player/login";
	}

}
