package tw.survival.service.Market;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.survival.model.Market.LogisticsBean;
import tw.survival.model.Market.OrderItemBean;
import tw.survival.model.Market.OrderItemRepository;

@Service
@Transactional
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemDao;

	@Autowired
	private LogisticsService logisticsService;

	public OrderItemBean insertOrder(OrderItemBean op) {
		try {
			op = orderItemDao.save(op);
			LogisticsBean logistics = new LogisticsBean();
			logistics.setOrderItem(op);
			logistics.setPlayer(op.getPlayer());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.DATE, 1);
			logistics.setStart_date(calendar.getTime());
			calendar.add(Calendar.DATE, 3);
			logistics.setArrive_date(calendar.getTime());
			logistics.setStatus("處理中");
			logisticsService.insertLogistics(logistics);
			return op;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public OrderItemBean findById(Integer id) {
		Optional<OrderItemBean> optional = orderItemDao.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}
		System.out.println("沒找到id 為" + id + "的資料");
		return null;
	}

	public List<OrderItemBean> findAllOrderItem() {
		return orderItemDao.findAll();
	}

	public OrderItemBean getProductById(Integer id) {
		Optional<OrderItemBean> optional = orderItemDao.findById(id);

		if (optional.isPresent()) { // 判斷optional有東西
			return optional.get();
		}
		return null;
	}

	public OrderItemBean update(OrderItemBean oBean) {
		Optional<OrderItemBean> optional = orderItemDao.findById(oBean.getId());
		if (optional.isPresent()) {
			OrderItemBean order = optional.get();
			order.setOrder_create_date(oBean.getOrder_create_date());
			order.setPlayer(oBean.getPlayer());
			order.setProducts(oBean.getProducts());
			order.setStatus(oBean.getStatus());
			return orderItemDao.save(order);
		}
		return null;
	}

	// d
	public void deleteById(Integer id) {
		OrderItemBean ob = findById(id);
		ob.setPlayer(null);
		orderItemDao.deleteById(id);
		return;
	}

	// ID搜尋
	public List<OrderItemBean> findByfk_player_id(Integer fk_player_id) {
		return orderItemDao.findOrderItemidLike(fk_player_id);
	}

}