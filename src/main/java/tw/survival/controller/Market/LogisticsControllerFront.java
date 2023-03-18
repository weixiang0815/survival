package tw.survival.controller.Market;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.survival.model.Market.LogisticsBean;
import tw.survival.model.Market.OrderItemBean;
import tw.survival.service.Market.LogisticsService;
import tw.survival.service.Market.OrderItemService;

@Controller
public class LogisticsControllerFront {

	@Autowired
	private LogisticsService LogisticsService;

	@Autowired
	private OrderItemService oService;

	// r
	@GetMapping("/front/Market/logistics")
	public String getAllLogistics(Model model) {
		List<LogisticsBean> list1 = LogisticsService.findAllLogistics();
		model.addAttribute("list", list1);
		return "/front/Market/logistics";
	}

	@GetMapping("/front/Market/order")
	public String getAllorder(Model model) {
		List<OrderItemBean> orderList2 = oService.findAllOrderItem();
		model.addAttribute("orderList", orderList2);
		return "/front/Market/order";
	}

	@ResponseBody
	@GetMapping("/order/dropped3")
	public Integer dropped(@RequestParam("id") Integer orderid) {
		try {
			OrderItemBean order = oService.findById(orderid);
			LogisticsBean logistics =  LogisticsService.findByOrderId(orderid);
			logistics.setStatus("棄單");
			LogisticsService.update(logistics);
			order.setStatus("棄單");
			oService.update(order);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
// 已取消
//		@GetMapping("/front/Market/cancel")
//		public String getLogistics(Model model) {
//			List<LogisticsBean> list1 = LogisticsService.findAllLogistics();
//			model.addAttribute("list", list1);
//			return "/front/Market/cancel";
//		}