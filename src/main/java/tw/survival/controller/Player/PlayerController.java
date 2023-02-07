package tw.survival.controller.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.survival.service.Player.PlayerService;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService uService;

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

}