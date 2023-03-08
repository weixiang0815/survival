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
public class LogisticsController {

	@Autowired
	private LogisticsService LogisticsService;

	@Autowired
	private OrderItemService oService;

	@GetMapping("/Market/add_Logistics")
	private String Logistics() {
		return "/back/Market/add_Logistics";
	}

	// 新增物流資料
	@ResponseBody
	@PostMapping("Market/addLogistics")
	public String addLogistics(@RequestParam("start_date") Date start_date,
			@RequestParam("arrive_date") Date arrive_date, @RequestParam("status") String status)
			throws IOException {

		LogisticsBean lb = new LogisticsBean();
		lb.setStart_date(start_date);
		lb.setArrive_date(arrive_date);
		lb.setStatus(status);

		LogisticsService.insertLogistics(lb);

		return "上傳成功 <meta http-equiv=\"refresh\" content=\"0.1; url=http://localhost:8080/Survival/Market/all_Logistics\">";
	}

	// 讀取全部物流
	@GetMapping("/Market/all_Logistics")
	public String getAllLogistics(Model model) {
		List<OrderItemBean> orderList = oService.findAllOrderItem();
		model.addAttribute("orderList", orderList);
		List<LogisticsBean> list = LogisticsService.findAllLogistics();
		model.addAttribute("list", list);
		return "/back/Market/show_AllLogistics";
	}

	// u
	@GetMapping("/Market/editLogistics")
	public String editLogistics(@RequestParam("id") Integer id, Model model) {
		LogisticsBean logistics = LogisticsService.findById(id);
		model.addAttribute("logistics", logistics);
		return "/back/Market/editLogistics";
	}

	@PutMapping("/Market/editLogistics")
	public String updateLogistics(@ModelAttribute("logistics") LogisticsBean logistics) {
		LogisticsService.update(logistics);
		return "redirect:/Market/all_Logistics";
	}

	// d
	@DeleteMapping("/Market/deleteLogistics")
	public String deleteLogistics(@RequestParam("id") Integer id) {
		LogisticsService.deleteById(id);
		return "redirect:/Market/all_Logistics";
	}

}