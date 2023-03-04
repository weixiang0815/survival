package tw.survival.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackController {

	@GetMapping("/admin")
	public String goAdmin() {
		return "back/index";
	}

}