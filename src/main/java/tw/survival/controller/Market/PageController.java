package tw.survival.controller.Market;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

	@GetMapping("Market/marketMain")
	public String goToIndex(Model model) {
		return "back/Market/marketMain";
	}
	

	@GetMapping("/front/Market/shop")
	public String shopMain() {
		return "/front/Market/shop";
	}

	@GetMapping("/playAjax/intro1")
	public String goAjaxIntro() {
		return "ajax/ajax1-intro1";
	}

	@GetMapping("/playAjax/sendPage")
	public String goAjaxSendDataPage() {
		return "ajax/ajax2-send";
	}

	@GetMapping("/playAjax/message")
	public String goAjaxMessage() {
		return "ajax/ajax3-message";
	}

}
