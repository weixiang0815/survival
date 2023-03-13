package tw.survival.controller.SendEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.survival.model.Player.PlayerBean;
import tw.survival.service.email.EmailService;

@Controller
@SessionAttributes({ "employee", "player" })
public class SendMailController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/email.main")
	public String SendEmail(Model model) {
		PlayerBean player = (PlayerBean) model.getAttribute("player");
		emailService.sendHtmlMail(player);
		return "Player/index";

	}

}