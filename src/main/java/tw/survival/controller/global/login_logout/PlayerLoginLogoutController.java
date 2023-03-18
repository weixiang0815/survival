package tw.survival.controller.global.login_logout;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
			return "front/Player/loginSystem";
		}
		if (player != null && player.getStatus() == 1) {
			m.addAttribute("player", player);
			return "redirect:/";
		}
		return "front/Player/loginSystem";
	}

	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/Player/login";
	}

//	@GetMapping("/login")
//	public ModelAndView loginfb() {
//		String accessToken=null;
//		DefaultFacebookClient facebookClient = new DefaultFacebookClient(accessToken);
//	    String loginDialogUrl = facebookClient.getLoginDialogUrl("YOUR_REDIRECT_URL", "YOUR_PERMISSIONS");
//	    return new ModelAndView("redirect:" + loginDialogUrl);
//	}

	/**
	 * 檢查帳號是否存在與已啟動的 AJAX Controller
	 * 
	 * @param account  欲檢查的帳號
	 * @param password 欲檢查的密碼
	 * @return 如果帳號不存在則回傳 0，如果存在但尚未啟動則回傳 1，如果已啟動則回傳 2
	 * @author 夏梓喻
	 * @author 王威翔
	 */
	@ResponseBody
	@PostMapping("/player/status")
	public Integer checkstatus(@RequestParam String account, @RequestParam String password) {
		PlayerBean player = service.login(account, password);
		if (player == null) {
			return 0;
		} else {
			return player.getStatus() == 0 ? 1 : 2;
		}
	}

}