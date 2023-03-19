package tw.survival.controller.back.Market;

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

import tw.survival.model.Market.LogisticsBean;
import tw.survival.model.Market.OrderItemBean;
import tw.survival.service.Market.LogisticsService;
import tw.survival.service.Market.OrderItemService;

@Controller
public class OrderItemController {

	@Autowired
	private OrderItemService oService;

	@Autowired
	private LogisticsService logisticsService;

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

	@GetMapping("/Market/all_OrderItem")
	public String getAllOrderItem(Model model) {
		List<OrderItemBean> orderList = oService.findAllOrderItem();
		model.addAttribute("orderList", orderList);
		return "/back/Market/show_AllOrderItem";
	}

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
	public String findOrderItemidLike(@RequestParam("id") Integer fk_player_id, Model model) {
		List<OrderItemBean> searchResult1 = oService.findByfk_player_id(fk_player_id);
		model.addAttribute("SearchResult1", searchResult1);
		return "back/Market/all_Logistics";
	}

	// 從訂單棄單
//	@GetMapping("/Market/drop-order-from-order")
//	public String dropOrderFromOrder(@RequestParam("orderId") Integer orderId, Model model) {
//		OrderItemBean order = oService.findById(orderId);
//		order.setStatus("棄單");
//		oService.update(order);
//		LogisticsBean logistics = logisticsService.findByOrderId(orderId);
//		logistics.setStatus("棄單");
//		logisticsService.update(logistics);
//		return "";
//	}
//
//	//	從物流出貨
//	@GetMapping("/Market/receive")
//	public String receive(@RequestParam("orderId") Integer orderId, Model model) {
//		OrderItemBean order = oService.findById(orderId);
//		order.setStatus("已取貨");
//		oService.update(order);
//		LogisticsBean logistics = logisticsService.findByOrderId(orderId);
//		logistics.setStatus("已取貨");
//		logisticsService.update(logistics);
//		return "/back/Market/editOrderItem";
//	}
	@ResponseBody
	@GetMapping("/Market/processing2")
	public Integer processing(@RequestParam("id") Integer orderid) {
		try {
			OrderItemBean order = oService.findById(orderid);
			LogisticsBean logistics =  logisticsService.findByOrderId(orderid);
			logistics.setStatus("處理中");
			logisticsService.update(logistics);
			order.setStatus("處理中");
			oService.update(order);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@ResponseBody
	@GetMapping("/Market/sentout2")
	public Integer sentout(@RequestParam("id") Integer orderid) {
		try {
			OrderItemBean order = oService.findById(orderid);
			LogisticsBean logistics =  logisticsService.findByOrderId(orderid);
			logistics.setStatus("已出貨");
			logisticsService.update(logistics);
			order.setStatus("已出貨");
			oService.update(order);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@ResponseBody
	@GetMapping("/Market/arrived2")
	public Integer arrived(@RequestParam("id") Integer orderid) {
		try {
			OrderItemBean order = oService.findById(orderid);
			LogisticsBean logistics =  logisticsService.findByOrderId(orderid);
			logistics.setStatus("已到貨");
			logisticsService.update(logistics);
			order.setStatus("已到貨");
			oService.update(order);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	@ResponseBody
	@GetMapping("/Market/pickedup")
	public Integer pickedup(@RequestParam("id") Integer orderid) {
		try {
			OrderItemBean order = oService.findById(orderid);
			LogisticsBean logistics =  logisticsService.findByOrderId(orderid);
			logistics.setStatus("已取貨");
			logisticsService.update(logistics);
			order.setStatus("已取貨");
			oService.update(order);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	@ResponseBody
	@GetMapping("/Market/dropped2")
	public Integer dropped(@RequestParam("id") Integer orderid) {
		try {
			OrderItemBean order = oService.findById(orderid);
			LogisticsBean logistics =  logisticsService.findByOrderId(orderid);
			logistics.setStatus("棄單");
			logisticsService.update(logistics);
			order.setStatus("棄單");
			oService.update(order);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}