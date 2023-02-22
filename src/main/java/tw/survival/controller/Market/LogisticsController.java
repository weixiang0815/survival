package tw.survival.controller.Market;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.survival.model.Market.LogisticsBean;
import tw.survival.service.Market.LogisticsService;

@Controller
public class LogisticsController {

	@Autowired
	private LogisticsService logisticsService;

	@GetMapping("/Market/add_Logistics")
	private String Logistics() {
		return "Market/add_Logistics";
	}

	@PostMapping("/Market/addLogistics")
	@ResponseBody
	public String addLogistics(@RequestParam("start_date") Date start_date,
			@RequestParam("arrive_date") Date arrive_date, @RequestParam("status") String status) throws IOException {

		LogisticsBean lb = new LogisticsBean();
		lb.setStart_date(start_date);
		lb.setArrive_date(arrive_date);
		lb.setStatus(status);

//		LogisticsService.insertLogistics(lb);

		return "新增成功";
	}

	// r
	@GetMapping("/Market/all_Logistics")
	public String getAllLogistics(Model model) {
		List<LogisticsBean> list = logisticsService.findAllLogistics();
		model.addAttribute("list", list);
		return "/Market/show_AllLogistics";
	}
	// d

	@RequestMapping(value = "/Market/deleteLogistics", method = RequestMethod.DELETE)
	public String deleteLogistics(@RequestParam("deleteid") Integer id) {
		logisticsService.deleteById(id);
		return "redirect:/Market/all_Logistics";
	}
}
