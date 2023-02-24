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
import tw.survival.service.login_logout.login_logoutService;

@Controller
@SessionAttributes(names = { "Employee" })
public class EmployeeloginController {

	@Autowired
	public login_logoutService service;

	@GetMapping("/Employee/login")
	public String loginemp() {
		return "Employee/loginSystem";
	}

	@PostMapping("/Employee/loginSystem")
	public String checkLogemp(@RequestParam("account") String account, @RequestParam("password") String password,
			Model m) {
		EmployeeBean emp = service.loginEmp(account, password);
		if (emp != null) {
			m.addAttribute("employee", emp);
			return "Employee/loginSystem";
		}
		return "Employee/loginSystem";
	}

	@GetMapping("/emplogout")
	public String logout(HttpSession session) {
		session.setAttribute("emp", null);

		return "redirect:/Employee/login";
	}
}