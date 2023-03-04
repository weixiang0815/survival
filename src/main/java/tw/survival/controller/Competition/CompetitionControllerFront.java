package tw.survival.controller.Competition;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front")
public class CompetitionControllerFront {

	@GetMapping("/competition")
	public String goIndex() {
		return "front/Competition/index";
	}

	@GetMapping("/signup")
	public String goSignup() {
		return "front/Competition/signup";
	}

	@GetMapping("/competition/detail")
	public String goCompDetail() {
		return "front/Competition/compDetail";
	}

	@GetMapping("/competition/photo")
	public String goCompPhoto() {
		return "front/Competition/photo";
	}

	@GetMapping("/competition/history")
	public String goCompHistory() {
		return "front/Competition/history";
	}

}