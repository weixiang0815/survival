package tw.survival.controller.login_logout;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import tw.survival.model.Employee.EmployeeBean;

import tw.survival.service.login_logout.login_logoutService;

@Controller
@SessionAttributes({"employee"})
public class EmployeeloginLogoutController {

	@Autowired
	public login_logoutService service;
	
	@GetMapping("/Employee/login")
	public String loginemp() {
		return "back/Employee/loginSystem";
	}

	@PostMapping("/Employee/loginSystem")
	public String checkLogemp(@RequestParam("account") String account, 
			@RequestParam("password") String password,
			Model m) {
		Map<String, String> err = new HashMap<>();
		EmployeeBean emp = service.loginEmp(account, password);
		if (emp != null) {
			m.addAttribute("employee", emp);
			return "back/Employee/index";
		}else {
			err.put("msg", "帳號密碼不正確");
			m.addAttribute("errors", err);
		}
		return "back/Employee/loginSystem";
	}

	@GetMapping("/emplogout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/Employee/login";
	}
}