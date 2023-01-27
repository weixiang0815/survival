package tw.survival.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.survival.model.Account;
import tw.survival.model.AccountService;

@Controller
public class LoginSystemController {

	@Autowired
	private AccountService aService;

	@RequestMapping(path = "/loginsystemmain.controller", method = RequestMethod.GET)
//	@GetMapping(path = "loginsystemmain.controller")
//	@GetMapping("loginsystemmain.controller")
	public String processMainAction() {
		return "loginSystem";
	}

	@RequestMapping(path = "/checkLogin.controller", method = RequestMethod.POST)
	public String processAction(@RequestParam("username") String user, @RequestParam("userpwd") String pwd, Model m) {
		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		if (user == null || user.length() == 0) {
			errors.put("user", "使用者名稱不得為空白");
		}
		if (pwd == null || pwd.length() == 0) {
			errors.put("pwd", "密碼不得為空白");
		}
		if (errors != null && !errors.isEmpty()) {
			return "loginSystem";
		}
		boolean checkUser = aService.checkLogin(new Account(user, pwd));
		if (checkUser) {
			m.addAttribute("user", user);
			m.addAttribute("pwd", pwd);
			return "loginSuccess";
		}
		errors.put("msg", "請輸入正確的使用者名稱及密碼");
		return "loginSystem";
	}
}