package tw.survival.controller.front.CUD.Market;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

//	@GetMapping("/Market/add_Logistics")
//	private String Logistics() {
//		return "/back/Market/add_Logistics";
//	}

	// c
//	@ResponseBody
//	@PostMapping("/Market/addLogistics")
//	public String addLogistics(@RequestParam("start_date") Date start_date,
//			@RequestParam("arrive_date") Date arrive_date, @RequestParam("Logistics_status") String status)
//			throws IOException {
//
//		LogisticsBean lb = new LogisticsBean();
//		lb.setStart_date(start_date);
//		lb.setArrive_date(arrive_date);
//		lb.setStatus(status);
//
//		LogisticsService.insertLogistics(lb);
//
//		return "新增成功";
//	}

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