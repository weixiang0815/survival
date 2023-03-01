package tw.survival.controller.login_logout;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.survival.model.Employee.EmployeeBean;
import tw.survival.model.Player.PlayerBean;
import tw.survival.service.login_logout.login_logoutService;

@Controller
@SessionAttributes(names = { "player" })
public class PlayerloginController {

	@Autowired
	public login_logoutService service;

	@GetMapping("/Player/login")
	public String login() {
		return "back/Player/loginSystem";
	}

	@GetMapping("/Player/index")
	public String anotherPage(Model m) {
   PlayerBean player=new PlayerBean();
   m.addAttribute("player",player);
   
		return "redirect:/index";
	}

	@PostMapping("/Player/loginSystem")
	public String checklog(@RequestParam("account") String account, @RequestParam("password") String password, Model m,
			HttpSession session) {
		PlayerBean player = service.login(account, password);
		EmployeeBean emp = service.loginEmp(account, password);
		if (player != null) {
			session.setAttribute("player", player);
			return "back/Player/loginSuccess";
		}
		if (emp != null) {
			session.setAttribute("employee", emp);
			return "back/Player/loginSystem";
		}
		return "back/Player/loginSystem";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("player", null);
		return "redirect:/Player/login";
	}

}
