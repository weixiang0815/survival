package tw.survival.controller.Market;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

//	@GetMapping("/front/Market/Text")
//	public String goText() {
//		return "/front/Market/Text";
//	}

	@GetMapping("/playAjax/sendPage")
	public String goAjaxSendDataPage() {
		return "ajax/ajax2-send";
	}

	@GetMapping("/playAjax/message")
	public String goAjaxMessage() {
		return "ajax/ajax3-message";
	}

}