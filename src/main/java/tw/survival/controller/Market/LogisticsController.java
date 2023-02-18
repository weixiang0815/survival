package tw.survival.controller.Market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tw.survival.service.Market.LogisticsService;

@Controller
public class LogisticsController {
	
	@Autowired
	private LogisticsService LogisticsService;
	
	@GetMapping("/Market/add_Logistics")
	private String addLogistics() {
		return "Market/add_Logistics";
	}
	
	
	
}
