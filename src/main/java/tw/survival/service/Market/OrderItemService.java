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
			Date today = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(today);
			calendar.add(Calendar.DATE, 3);
			Date arriveDate = calendar.getTime();
			logistics.setStart_date(arriveDate);
			logistics.setArrive_date(arriveDate);
			logistics.setStatus("處理中");
			logisticsService.insertLogistics(logistics);
			return op;
		} catch (Exception e) {
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
		orderItemDao.save(oBean);
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