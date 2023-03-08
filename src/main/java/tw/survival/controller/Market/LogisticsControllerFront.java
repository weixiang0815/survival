package tw.survival.controller.Market;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		List<OrderItemBean> orderList2 = oService.findAllOrderItem();
		model.addAttribute("orderList", orderList2);
		List<LogisticsBean> list1 = LogisticsService.findAllLogistics();
		model.addAttribute("list", list1);
		return "/front/Market/logistics";
	}
}