package tw.survival.controller.Market;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageControllerFront {
	
	@GetMapping("front/Market/index")
	public String goToFrontIndex(Model model) {
		return "front/Market/index";
	}
	
	@GetMapping("front/Market/index.html")
	public String goToFrontIndexHtml(Model model) {
		return "front/Market/index.html";
	}

}
