package tw.survival.controller.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.survival.model.User.UserBean;
import tw.survival.model.User.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService uService;

	@GetMapping("/user")
	public String main() {
		return "User/index";
	}

	@GetMapping("/usersmain.controller")
	public String showForm(Model model) {
		return "User/user";
	}

	@GetMapping("/searchmain.controller")
	public String search(Model model) {
		return "User/Select";
	}

	@GetMapping("/loginsystemmain.controller")
	public String processMainAction() {
		return "User/loginSystem";
	}

	@GetMapping("/uploadmain.controller") // 新增圖
	public String processAction() {
		return "User/uploadFile";
	}

	// 應該要能上傳圖片
	@PostMapping("/addUser")
	public String submit(@RequestParam("name") String name, @RequestParam("account") String account,
			@RequestParam("password") String password,
			@RequestParam(name = "nickname", required = false) String nickname, @RequestParam("sex") String sex,
			@RequestParam("address") String address, @RequestParam("email") String email,
			@RequestParam("age") String age, @RequestParam("thumbnail") MultipartFile thumbnail, Model m) throws IOException {
		if (uService.getOneUserByAccount(account) != null) {
			m.addAttribute("error", "此帳號已存在");
			return "User/user";
		}
		UserBean user = new UserBean();
		user.setName(name);
		user.setAccount(account);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setSex(sex);
		user.setAddress(address);
		user.setEmail(email);
		user.setAge(age);
		if (thumbnail != null) {
			user.setThumbnail(thumbnail.getBytes());
		}
		uService.addUser(user);
		m.addAttribute("id", uService.getOneUserByAccount(account).getId());
		return "User/userResult";
	}

	@GetMapping("/deleteUserById")
	public String deleteUserById(@RequestParam("id") Integer id, Model m) {
		m.addAttribute("msg", uService.deleteUserById(id));
		return "User/deleteResult";
	}

	@PostMapping("/getOneUserById")
	public String searchOneUserById(@RequestParam(name = "id", required = false) Integer id, Model m) {
		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		UserBean user = uService.getOneUserById(id);
		if (user == null) {
			errors.put("idNotFound", "查無此 id");
			return "User/Select";
		}
		m.addAttribute("user", user);
		m.addAttribute("id", user.getId());
		return "User/selectOne";
	}

	@PostMapping("/getOneUserByAccount")
	public String searchOneUserByAccount(@RequestParam(name = "account", required = false) String account, Model m) {
		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		if (account == null) {
			errors.put("mustNotEmpty", "id 與帳號不得皆為空白");
			return "User/Select";
		}
		UserBean user = uService.getOneUserByAccount(account);
		if (user == null) {
			errors.put("accountNotFound", "查無此帳號");
			return "User/Select";
		}
		m.addAttribute("user", user);
		m.addAttribute("account", user.getAccount());
		return "User/selectOne";
	}

	@PostMapping("/getUsers")
	public String searchUsers(Model m) {
		List<UserBean> users = uService.getAllUsers();
		m.addAttribute("users", users);
		return "User/SelectAllResult";
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
			user = uService.getOneUserByAccount(account);
			m.addAttribute("loginsuccess", user.getName() + " 歡迎回來～～～");
			m.addAttribute("id", user.getId());
			return "User/loginSuccess";
		}
		errors.put("msg", "請輸入正確的使用者名稱及密碼");
		return "User/loginSystem";
	}

	@GetMapping("/updateUserById")
	public String updateSearch(@RequestParam("id") Integer id, Model m) {
		UserBean user = uService.getOneUserById(id);
		m.addAttribute("user", user);
		return "User/UpdateUser1";
	}

	@Transactional
	@PostMapping("/updateUser")
	public String update(@RequestParam("id") Integer id, @RequestParam("name") String name,
			@RequestParam("account") String account, @RequestParam("password") String password,
			@RequestParam(name = "nickname", required = false) String nickname, @RequestParam("sex") String sex,
			@RequestParam("address") String address, @RequestParam("email") String email,
			@RequestParam("age") String age, Model m,
			@RequestParam(name = "thumbnail", required = false) MultipartFile thumbnail) throws IOException {
		HashMap<String, String> msg = new HashMap<String, String>();
		m.addAttribute("msg", msg);
		try {
			UserBean user = uService.getOneUserById(id);
			user.setName(name);
			user.setAccount(account);
			user.setPassword(password);
			user.setNickname(nickname);
			user.setSex(sex);
			user.setAddress(address);
			user.setEmail(email);
			user.setAge(age);
			if (thumbnail != null) {
				user.setThumbnail(thumbnail.getBytes());
			}
			uService.updateUser(user);
			msg.put("success", "修改成功🎉🎉🎉");
		} catch (Exception e) {
			msg.put("fail", "修改失敗😥😥😥");
		}
		return "User/updateResult";
	}

	@Transactional
	@GetMapping(value = "/showImg", produces = "image/png")
	@ResponseBody
	public byte[] showImg(@RequestParam("id") Integer id, Model m) {
		return uService.getOneUserById(id).getThumbnail();
	}

}