package tw.survival.service.Market;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.survival.model.Market.OrderItemBean;
import tw.survival.model.Market.OrderItemRepository;

@Service
@Transactional
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemDao;

	public void insertOrder(OrderItemBean op) {
		orderItemDao.save(op);
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
	//d
	public void deleteById(Integer id) {

		OrderItemBean ob = findById(id);
		ob.setPlayer(null);
		orderItemDao.deleteById(id);
		return;
	}
}
