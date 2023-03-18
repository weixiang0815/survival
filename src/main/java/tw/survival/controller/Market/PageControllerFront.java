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

	@GetMapping("/front/Market/shop")
	public String shopMain() {
		return "/front/Market/shop";
	}
	
	@GetMapping("/front/Market/cart")
	public String cartMain() {
		return "/front/Market/cart";
	}
	
	@GetMapping("/Market/Cart/add")
	private String add_Cart() {
		return "/Market/Cart/add";
	}
	
	@GetMapping("/front/Market/checkout")
	private String checkOut() {
		return "/front/Market/checkout";
	}
	
	@GetMapping("front/Market/index.html")
	public String goToFrontIndexHtml(Model model) {
		return "front/Market/index.html";
	}
	

}