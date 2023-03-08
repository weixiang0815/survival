package tw.survival.controller.global.login_logout;

import java.util.List;

import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import tw.survival.model.Player.PlayerBean;
import tw.survival.service.login_logout.login_logoutService;
import tw.survival.validators.Playervalidator;

@Controller
@SessionAttributes({ "player" })
public class PlayerLoginLogoutController {
	@Autowired
	Playervalidator validator;

	@Autowired
	public login_logoutService service;

	@GetMapping("/Player/login")
	public String login() {
		return "front/Player/loginSystem";
	}

	@GetMapping("/Player/index")
	public String anotherPage(Model m) {
		PlayerBean player = new PlayerBean();
		m.addAttribute("player", player);

		return "redirect:/index";
	}

	@PostMapping("/Player/loginSystem")
	public String checklog(@Valid @ModelAttribute PlayerBean player1, @RequestParam("account") String account,
			@RequestParam("password") String password, BindingResult bindingResult, Model m) {
		PlayerBean player = service.login(account, password);
		validator.validate(player1, bindingResult);
		if (bindingResult.hasErrors()) {
			List<ObjectError> list = bindingResult.getAllErrors();
			m.addAttribute("alertMessage", "帳號密碼錯誤");
			m.addAttribute("errors", list);
			for (ObjectError error : list) {
				System.out.println("有錯誤：" + error);
			}
			return "back/Player/loginSystem";
		}
		if (player != null) {
			m.addAttribute("player", player);
			return "redirect:/";
		}
		return "back/Player/loginSystem";
	}

	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/Player/login";
	}

}