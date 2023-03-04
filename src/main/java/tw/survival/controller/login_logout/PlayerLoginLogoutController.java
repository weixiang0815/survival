package tw.survival.controller.login_logout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import tw.survival.model.Player.PlayerBean;
import tw.survival.service.login_logout.login_logoutService;

@Controller
@SessionAttributes({ "player" })
public class PlayerLoginLogoutController {

	@Autowired
	public login_logoutService service;

	@GetMapping("/Player/login")
	public String login() {
		return "back/Player/loginSystem";
	}

	@GetMapping("/Player/index")
	public String anotherPage(Model m) {
		PlayerBean player = new PlayerBean();
		m.addAttribute("player", player);

		return "redirect:/index";
	}

	@PostMapping("/Player/loginSystem")
	public String checklog(@RequestParam("account") String account, @RequestParam("password") String password,
			Model m) {
		PlayerBean player = service.login(account, password);

		if (player != null) {
			m.addAttribute("player", player);
			return "back/Player/loginSuccess";
		}
		return "back/Player/loginSystem";
	}

	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/Player/login";
	}

}