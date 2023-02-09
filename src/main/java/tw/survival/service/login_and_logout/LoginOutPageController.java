package tw.survival.service.login_and_logout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginOutPageController {

	@GetMapping("login_Page")
	public String playerlogin() {
		
		return"login";
	}
	@GetMapping("logout_Page")
	public String playerlogout() {
		
		return"logout";
	}
}
