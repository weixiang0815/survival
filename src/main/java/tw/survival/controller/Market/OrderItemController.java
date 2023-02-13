package tw.survival.controller.Market;

import java.io.IOException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.survival.model.Market.OrderItemBean;
import tw.survival.service.Market.OrderItemService;

@Controller
public class OrderItemController {

	
	@Autowired
	private OrderItemService oService;
	
	
	@GetMapping("/Market/add_OrderItem")
	private String addOrder() {
		return "Market/add_OrderItem";
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
	
	return "上傳成功";	
}
	
}