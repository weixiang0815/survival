package tw.survival.controller.Competition;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front")
public class CompetitionControllerFront {

	@GetMapping("/Competition")
	public String goIndex() {
		return "front/Competition/example";
	}
	
}