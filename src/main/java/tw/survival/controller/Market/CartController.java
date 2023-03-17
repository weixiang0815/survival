package tw.survival.controller.Market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	private CartService cartService;

	@GetMapping("/Market/Cart/test")
	public String addProductToCart(Model model) {
		model.addAttribute("product", productService.findById(1));
		model.addAttribute("player", playerService.findByBean(1));
		model.addAttribute("quantity", cartService.fingByCartId(1));
		model.addAttribute("cart", new CartBean());
		return "back/Market/addToCart";
	}
	
	//找會員ID
	@ResponseBody
	@GetMapping("/Market/Cart/playerId")
	public String fingByPlayerId(@RequestParam("playerId") Integer playerId) {
		cartService.fingByPlayerId(playerId);
		return "front/Market/cart";
	}
	

	//新增至購物車
	@GetMapping("/Market/Cart/add")
	public String addCart(@RequestParam("productId") Integer productId, @RequestParam("playerId") Integer playerId,
			@RequestParam("quantity") Integer quantity, Model model) {
		CartBean cart = new CartBean();
		cart.setPlayer(playerService.findByBean(playerId));
		cart.setProduct(productService.findById(productId));
		cart.setQuantity(quantity);
		cart = cartService.insertCart(cart);
		model.addAttribute("Cart_List", cart);
		return "/front/Market/cart";
//		return CartService.listCartItems(playerId);
	}
	
	@DeleteMapping("/Market/Cart/delete")
	public String deleteProduct(@RequestParam("id") Integer id) {
		cartService.deleteCartItem(id);
		return "redirect:/front/Market/cart";
	}	
	

	@PostMapping("/Market/Cart/add1")
	public String addCart(@ModelAttribute("cart") CartBean cart, Model model) {
		cart = cartService.insertCart(cart);
		if (cart != null) {
			model.addAttribute("Cart_List", cart);
			return "back/Market/marketMain";
		} else {
			return "back/Competition/index";
		}
	}

//	@GetMapping("/Market/Cart/showCart")
//	public String showCart(@RequestParam("playerId") Integer playerId,Model model) {
//		model.addAttribute("player", playerService.findByBean(1));
//		model.addAttribute("cart", new CartBean());
//		return "front/Market/cart";
//	}
//	

	
}