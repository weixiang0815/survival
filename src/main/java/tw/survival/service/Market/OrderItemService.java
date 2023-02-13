package tw.survival.service.Market;

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
	
}
