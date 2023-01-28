package tw.survival.controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tw.survival.model.User.UserBean;
import tw.survival.model.User.UserService;

@Controller
public class UserController {

	@GetMapping("/usersmain.controller")
	public String showForm(Model model) {
		return "user";
	}

	@PostMapping("addUser")
	public String submit(@ModelAttribute("user") UserBean user, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "usersError";
		}
		model.addAttribute("name", user.getName());
		model.addAttribute("account", user.getAccount());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("sex", user.getSex());
		model.addAttribute("address", user.getAddress());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("age", user.getAge());
		// 此處測試 UserService 能否註冊
		new UserService().addUser(user);
		return "usersResult";
	}
	
}