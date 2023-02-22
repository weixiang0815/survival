package tw.survival.controller.login_logout;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.survival.model.Employee.EmployeeBean;
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

	@GetMapping("/Employee/login")
	public String loginemp() {
		return "Employee/loginSystem";
	}

	@PostMapping("/Player/loginSystem")
	public String checklog(@RequestParam("account") String account, @RequestParam("password") String password,
			HttpSession session) {
		PlayerBean player = service.login(account, password);
		EmployeeBean emp = service.loginEmp(account, password);
		if (player != null) {
			session.setAttribute("player", player);
			return "Player/loginSuccess";
		}
		if(emp != null) {
			session.setAttribute("employee", emp);
			return"Player/loginSystem";
		}
		return "Player/loginSystem";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("emp", null);
		session.setAttribute("player", null);
		return "redirect:/Player/login";
	}

	@PostMapping("/Employee/loginSystem")
	public String checkLogemp(@RequestParam("account") String account, @RequestParam("password") String password,
			HttpSession session) {
		EmployeeBean emp = service.loginEmp(account, password);
		if (emp != null) {
			session.setAttribute("employee", emp);
			return "Employee/loginSystem";
		}
		return "Employee/loginSystem";
	}

}
