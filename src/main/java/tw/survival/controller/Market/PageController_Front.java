package tw.survival.controller.Market;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController_Front {

	@GetMapping("/Market/index.html")
	public String goToFrontIndex(Model model) {
		return "front/Market/index.html";
	}

}