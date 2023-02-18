package tw.survival.controller.Market;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.survival.model.Market.LogisticsBean;
import tw.survival.service.Market.LogisticsService;

@Controller
public class LogisticsController {
	
	@Autowired
	private LogisticsService LogisticsService;
	
	@GetMapping("/Market/Logistics")
	private String Logistics() {
		return "Market/Logistics";
	}
	
	@ResponseBody
	@PostMapping("/Market/addLogistics")
	public String addLogistics(
			@RequestParam("order_create_date") Date Logistics_create_date,
			@RequestParam("arrive_date") Date arrive_date,
			@RequestParam("Logistics_status") String status
		
			) throws IOException {
		LogisticsBean lb = new LogisticsBean();
		lb.setStar_date(Logistics_create_date);
		lb.setArrive_date(arrive_date);
		lb.setStatus(status);

		LogisticsService.insertLogistics(lb);

		return "新增成功";
	}
	
	
}
