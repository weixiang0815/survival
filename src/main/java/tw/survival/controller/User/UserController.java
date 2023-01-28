package tw.survival.controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@PostMapping("addUser")
	public String submit(
			@RequestParam("name") String name,
			@RequestParam("account") String account,
			@RequestParam("password") String password,
			@RequestParam("sex") String sex,
			@RequestParam("address") String address,
			@RequestParam("email") String email,
			@RequestParam("age") String age,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "usersError";
		}
		UserBean user=new UserBean(name,account,password,sex,address,email,age);
		
		
		// 此處測試 UserService 能否註冊
		new UserService().addUser(user);
		return "usersResult";
	}
	
}