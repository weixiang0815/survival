package tw.survival.controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.survival.model.User.UserBean;
import tw.survival.model.User.UserService;

@Controller
public class UserController {

	@GetMapping("/usersmain.controller")
	public String showForm(Model model) {
		return "user";
	}

	@Autowired
	private UserService uService;
	
	@PostMapping("/addUser")
	public String submit(
			@RequestParam("name") String name,
			@RequestParam("account") String account,
			@RequestParam("password") String password,
			@RequestParam("sex") String sex,
			@RequestParam("address") String address,
			@RequestParam("email") String email,
			@RequestParam("age") String age,
			 ModelMap model) {
		
		System.out.println(sex);
		UserBean user=new UserBean(name,account,password,sex,address,email,age);
		
		
		// 此處測試 UserService 能否註冊
		uService.addUser(user);
		return "userResult";
	}
	
}