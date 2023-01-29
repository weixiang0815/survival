package tw.survival.controller.User;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.survival.model.User.UserBean;
import tw.survival.model.User.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService uService;

	@GetMapping("/usersmain.controller")
	public String showForm(Model model) {
		return "user";
	}

	@GetMapping("/searchmain.controller")
	public String search(Model model) {
		return "select";
	}

	@GetMapping("loginsystemmain.controller")
	public String processMainAction() {
		return "loginSystem";
	}

	@PostMapping("/addUser")
	public String submit(@RequestParam("name") String name, @RequestParam("account") String account,
			@RequestParam("password") String password, @RequestParam("sex") String sex,
			@RequestParam("address") String address, @RequestParam("email") String email,
			@RequestParam("age") String age) {
		UserBean user = new UserBean(name, account, password, sex, address, email, age);
		uService.addUser(user);
		return "userResult";
	}
	
	@GetMapping("/deleteUserById")
	public String deleteUserById(@RequestParam("id") Integer id, Model m) {
		m.addAttribute("msg", uService.deleteUserById(id));
		return "deleteResult";
	}

	@PostMapping("/getOneUserById")
	public String searchOneUserById(@RequestParam("id") Integer id, Model m) {
		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		UserBean user = null;
		if (id != null) {
			user = uService.getOneUserById(id);
			if (user == null) {
				errors.put("idNotFound", "查無此 id");
				return "select";
			}
		} else {
			errors.put("mustNotEmpty", "id 與帳號不得皆為空白");
			return "select";
		}
		m.addAttribute("user", user);
		return "selectOne";
	}
	
	@PostMapping("/getOneUserByAccount")
	public String searchOneUserByAccount(@RequestParam("account") String account, Model m) {
		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		UserBean user = null;
		if (account != null) {
			user = uService.getOneUserByAccount(account);
			if (user == null) {
				errors.put("accountNotFound", "查無此帳號");
				return "select";
			}
		} else {
			errors.put("mustNotEmpty", "id 與帳號不得皆為空白");
			return "select";
		}
		m.addAttribute("user", user);
		return "selectOne";
	}

	@PostMapping("/getUsers")
	public String searchUsers(Model m) {
		List<UserBean> users = uService.getAllUsers();
		m.addAttribute("users", users);
		return "selectAllResult";
	}

	@PostMapping("/checkLogin.controller")
	public String processAction(@RequestParam("account") String account, @RequestParam("password") String password,
			Model m) {
		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		if (account == null || account.length() == 0) {
			errors.put("account", "使用者名稱不得為空白");
		}
		if (password == null || password.length() == 0) {
			errors.put("password", "密碼不得為空白");
		}
		if (errors != null && !errors.isEmpty()) {
			return "loginSystem";
		}
		UserBean user = new UserBean();
		user.setAccount(account);
		user.setPassword(password);
		boolean checkUser = uService.checkLogin(user);
		if (checkUser) {
			m.addAttribute("account", account);
			m.addAttribute("password", password);
			return "loginSuccess";
		}
		errors.put("msg", "請輸入正確的使用者名稱及密碼");
		return "loginSystem";
	}

}