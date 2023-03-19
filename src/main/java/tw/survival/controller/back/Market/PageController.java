package tw.survival.controller.back.Market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.survival.model.Market.CartBean;
import tw.survival.service.Market.CartService;
import tw.survival.service.Market.ProductService;
import tw.survival.service.Player.PlayerService;

@Controller
public class PageController {

	@Autowired
	private ProductService productService;

	@Autowired
	private PlayerService playerService;

	@Autowired
	private CartService cartService;

	@GetMapping("/Market/Cart/test")
	public String addProductToCart(Model model) {
		model.addAttribute("product", productService.findById(1));
		model.addAttribute("player", playerService.findByBean(1));
		model.addAttribute("quantity", cartService.fingByCartId(1));
		model.addAttribute("cart", new CartBean());
		return "back/Market/addToCart";
	}

	@GetMapping("Market/marketMain")
	public String goToIndex(Model model) {
		return "back/Market/marketMain";
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