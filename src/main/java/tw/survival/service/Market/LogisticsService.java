package tw.survival.service.Market;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Market.LogisticsBean;
import tw.survival.model.Market.LogisticsDao;
import tw.survival.model.Market.LogisticsRepository;

@Service
@Transactional
public class LogisticsService {
	
	@Autowired
	private LogisticsDao logisticsDao;

	@Autowired
	private LogisticsRepository LogisticsDao;

	public LogisticsService() {
	}

	// c
	public void insertLogistics(LogisticsBean Logistics) {
		LogisticsDao.save(Logistics);
	}

	// r
	public LogisticsBean findById(Integer id) {
		Optional<LogisticsBean> optional = LogisticsDao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		System.out.println("沒找到id 為" + id + "的資料");
		return null;
	}

	public LogisticsBean getOneLogisticsById(Integer id) {
		Optional<LogisticsBean> optional = LogisticsDao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public LogisticsBean findByOrderId(Integer orderId) {
		try {
			return LogisticsDao.findByOrderItemId(orderId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<LogisticsBean> findAllLogistics() {
		return LogisticsDao.findAll();
	}

	// d
	public void deleteById(Integer id) {
		LogisticsBean lb = findById(id);
//		lb.setInventory(null);
		lb.setOrderItem(null);
		lb.setPlayer(null);
		LogisticsDao.deleteById(id);
	}

	public LogisticsBean update(LogisticsBean logistics) {
		Optional<LogisticsBean> optional = LogisticsDao.findById(logistics.getId());
		if (optional.isPresent()) {
			LogisticsBean oldLogistics = optional.get();
			oldLogistics.setArrive_date(logistics.getArrive_date());
			oldLogistics.setStart_date(logistics.getStart_date());
			oldLogistics.setOrderItem(logistics.getOrderItem());
			oldLogistics.setPlayer(logistics.getPlayer());
			oldLogistics.setStatus(logistics.getStatus());
			return LogisticsDao.save(oldLogistics);
		}
		return null;
	}

	public List<LogisticsBean> multiSearch(String[] conditions) {
		return logisticsDao.multiSearch(conditions);
	}

}