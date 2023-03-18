package tw.survival.controller.Market;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tw.survival.model.Market.CartBean;
import tw.survival.model.Market.OrderItemBean;
import tw.survival.model.Market.ProductBean;
import tw.survival.service.Market.CartService;
import tw.survival.service.Market.OrderItemService;
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

	@Autowired
	private OrderItemService orderService;

	@GetMapping("/Market/Cart/test")
	public String addProductToCart(Model model) {
		model.addAttribute("product", productService.findById(1));
		model.addAttribute("player", playerService.findByBean(1));
		model.addAttribute("quantity", cartService.fingByCartId(1));
		model.addAttribute("cart", new CartBean());
		return "back/Market/addToCart";
	}

	// 找會員ID
	@ResponseBody
	@GetMapping("/Market/Cart/playerId")
	public String fingByPlayerId(@RequestParam("playerId") Integer playerId) {
		cartService.fingByPlayerId(playerId);
		return "front/Market/cart";
	}

	// 找全部購物車
	@GetMapping("/Market/allCart")
	public ModelAndView getAllCart(ModelAndView mav) {
		List<CartBean> list = cartService.findAllCart();
		mav.setViewName("/front/Market/cart");
		mav.getModel().put("Cart_List", list);
		return mav;
	}

	// 新增至購物車
	@PostMapping("/Market/Cart/add")
	public String addCart(@RequestParam("productId") Integer productId, @RequestParam("playerId") Integer playerId,
			Model model) {
		CartBean cart = new CartBean();
		cart.setPlayer(playerService.findByBean(playerId));
		cart.setProduct(productService.findById(productId));
		cart = cartService.insertCart(cart);
		model.addAttribute("Cart_List", cart);
		return "redirect:/Market/allCart";
	}

	@DeleteMapping("/Market/Cart/delete")
	public String deleteCarById(@RequestParam("id") Integer id) {
		cartService.deleteCartById(id);
		return "redirect:/Market/allCart";
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

	@PostMapping("/Market/Cart/changeToOrder")
	public String cartToOrder(@RequestParam("cartIds") Integer[] cartIds, @RequestParam("playerId") Integer playerId,
			Model model) {
		OrderItemBean orderItem = new OrderItemBean();
		orderItem.setPlayer(playerService.findByBean(playerId));
		List<ProductBean> lists = new ArrayList<>();
		for (Integer cartId : cartIds) {
			CartBean cart = cartService.fingByCartId(cartId);
			ProductBean product = cart.getProduct();
			lists.add(product);
		}
		orderItem.setProducts(lists);
		orderItem.setStatus("處理中");
		orderItem = orderService.insertOrder(orderItem);
		for (Integer cartId : cartIds) {
			cartService.deleteCartById(cartId);
		}
		model.addAttribute("orderItem", orderItem);
		return "front/Market/checkout";
	}

}