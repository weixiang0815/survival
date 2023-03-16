package tw.survival.controller.Market;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.survival.model.Market.OrderItemBean;
import tw.survival.model.Market.OrderItemRepository;
import tw.survival.service.Market.OrderItemService;

@Controller
public class OrderItemController {

	@Autowired
	private OrderItemService oService;
	

	@GetMapping("/Market/add_OrderItem")
	private String addOrder() {
		return "/back/Market/add_OrderItem";
	}

	@ResponseBody
	@PostMapping("OrderItem/addorder")
	public String addOrderItem(@RequestParam("order_create_date") Date order_create_date,
			@RequestParam("status") String status) throws IOException {
		OrderItemBean ob = new OrderItemBean();
		ob.setOrder_create_date(order_create_date);
		ob.setStatus(status);

		oService.insertOrder(ob);

//	OrderItemRepository

		return "上傳成功 <meta http-equiv=\"refresh\" content=\"0.1; url=http://localhost:8080/Survival/Market/all_Logistics\">";
		
	}

//	@GetMapping("/Market/all_OrderItem")
//	public String getAllOrderItem(Model model) {
//	    List<OrderItemBean> orderList = oService.findAllOrderItem();
//	    model.addAttribute("orderList", orderList);
//	    return "/back/Market/show_AllLogistics";
//	}
//u
	@GetMapping("/Market/editOrder")
	public String editOrder(@RequestParam("id") Integer id, Model model) {
		OrderItemBean order = oService.findById(id);
		model.addAttribute("order", order);
		return "/back/Market/editOrderItem";
	}

	@PutMapping("/Market/editOrder")
	public String updateOrder(@ModelAttribute("order") OrderItemBean order) {
		oService.update(order);
		return "redirect:/Market/all_Logistics";
	}
//d
	@DeleteMapping("/Market/deleteOrder")
	public String deleteOrderItem(@RequestParam("id") Integer id) {
		oService.deleteById(id);
		return "redirect:/Market/all_Logistics";
	}
	// 搜尋
	@PostMapping("/Market/orderItemidLike")
	public String findOrderItemidLike(@RequestParam("id") String fk_player_id, Model model) {
	    List<OrderItemBean> searchResult1 = oService.findByfk_player_id(fk_player_id);
	    model.addAttribute("SearchResult1", searchResult1);
	    return "back/Market/all_Logistics";
	}
}