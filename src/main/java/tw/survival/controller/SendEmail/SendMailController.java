package tw.survival.controller.SendEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tw.survival.service.email.EmailService;

@Controller
public class SendMailController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/email.main")
	public String SendEmail() {
		emailService.sendHtmlMail();
		return "Player/index";

	}

}