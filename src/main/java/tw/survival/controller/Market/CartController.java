package tw.survival.controller.Market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.survival.model.Market.CartBean;
import tw.survival.service.Market.CartService;
import tw.survival.service.Market.ProductService;
import tw.survival.service.Player.PlayerService;

@Controller
public class CartController {

	@Autowired
	private ProductService productService;

	@Autowired
	private PlayerService playerService;

	@Autowired
	private CartService CartService;
	
//	https://ithelp.ithome.com.tw/articles/10256080
//	https://www.youtube.com/watch?v=mCSm0xwWack
	

	@GetMapping("/Market/Cart/test")
	public String addProductToCart(Model model) {
		model.addAttribute("product", productService.findById(1));
		model.addAttribute("player", playerService.findByBean(1));
		model.addAttribute("cart", new CartBean());
		return "back/Market/addToCart";
	}

	@GetMapping("/Market/Cart/add")
	public String addCart(@RequestParam("productId") Integer productId, @RequestParam("playerId") Integer playerId,
			Model model) {
		CartBean cart = new CartBean();
		cart.setPlayer(playerService.findByBean(playerId));
		cart.setProduct(productService.findById(productId));
		cart = CartService.insertCart(cart);
		model.addAttribute("cart", cart);
		return "back/Market/marketMain";
	}

	@PostMapping("/Market/Cart/add")
	public String addCart(@ModelAttribute("cart") CartBean cart, Model model) {
		cart = CartService.insertCart(cart);
		if (cart != null) {
			model.addAttribute("cart", cart);
			return "back/Market/marketMain";
		} else {
			return "back/Competition/index";
		}
	}

}