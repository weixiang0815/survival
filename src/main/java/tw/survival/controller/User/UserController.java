package tw.survival.controller.User;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
		return "User/user";
	}

	@GetMapping("/searchmain.controller")
	public String search(Model model) {
		return "User/select";
	}

	@GetMapping("loginsystemmain.controller")
	public String processMainAction() {
		return "User/loginSystem";
	}

	@PostMapping("/addUser")
	public String submit(@RequestParam("name") String name, @RequestParam("account") String account,
			@RequestParam("password") String password, @RequestParam("sex") String sex,
			@RequestParam("address") String address, @RequestParam("email") String email,
			@RequestParam("age") String age) {
		UserBean user = new UserBean(name, account, password, sex, address, email, age);
		uService.addUser(user);
		return "User/userResult";
	}
	
	@GetMapping("/deleteUserById")
	public String deleteUserById(@RequestParam("id") Integer id, Model m) {
		m.addAttribute("msg", uService.deleteUserById(id));
		return "User/deleteResult";
	}

	@PostMapping("/getOneUserById")
	public String searchOneUserById(@RequestParam("id") Integer id, Model m) {
		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		UserBean user = uService.getOneUserById(id);
		if (user == null) {
			errors.put("idNotFound", "查無此 id");
			return "User/select";
		}
		m.addAttribute("user", user);
		return "User/selectOne";
	}
	
	@PostMapping("/getOneUserByAccount")
	public String searchOneUserByAccount(@RequestParam("account") String account, Model m) {
		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		if (account == null) {
			errors.put("mustNotEmpty", "id 與帳號不得皆為空白");
			return "User/select";
		}
		UserBean user = uService.getOneUserByAccount(account);
		if (user == null) {
			errors.put("accountNotFound", "查無此帳號");
			return "User/select";
		}
		m.addAttribute("user", user);
		return "User/selectOne";
	}

	@PostMapping("/getUsers")
	public String searchUsers(Model m) {
		List<UserBean> users = uService.getAllUsers();
		m.addAttribute("users", users);
		return "User/selectAllResult";
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
			return "User/loginSystem";
		}
		UserBean user = new UserBean();
		user.setAccount(account);
		user.setPassword(password);
		boolean checkUser = uService.checkLogin(user);
		if (checkUser) {
			m.addAttribute("account", account);
			m.addAttribute("password", password);
			return "User/loginSuccess";
		}
		errors.put("msg", "請輸入正確的使用者名稱及密碼");
		return "User/loginSystem";
	}
	
	@GetMapping("/updateUserById")
	public String updateSearch(@RequestParam("id") Integer id,Model m) {
		UserBean user = uService.getOneUserById(id);
		m.addAttribute("user", user);
		return "User/UpdateUser1";
	}
	
	@Transactional
	@PostMapping("/updateUser")
	public String update(@RequestParam("id") Integer id,@RequestParam("name") String name, @RequestParam("account") String account,
			@RequestParam("password") String password, @RequestParam("sex") String sex,
			@RequestParam("address") String address, @RequestParam("email") String email,
			@RequestParam("age") String age, Model m) {
		
		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if (name == null || name.length() == 0) {
			errors.put("name", "使用者名稱不得為空白");
		}
		if (account == null || account.length() == 0) {
			errors.put("account", "帳號不得為空白");
		}
		
		if (password == null || password.length() == 0) {
			errors.put("password", "密碼不得為空白");
		}
		if (sex == null || sex.length() == 0) {
			errors.put("sex", "性別不得為空白");
		}
		if (address == null || address.length() == 0) {
			errors.put("address", "住址不得為空白");
		}
		if (email == null || email.length() == 0) {
			errors.put("email", "信箱不得為空白");
		}
		if (age == null || age.length() == 0) {
			errors.put("age", "年齡不得為空白");
		}
		
		
		if (errors != null && !errors.isEmpty()) {
			return "User/UpdateUser";
		}
		
		
		UserBean user = new UserBean(name, account, password, sex, address, email, age);
		user.setId(id);
		uService.updateUser(user);
		return "User/updateResult";
	}

}