package tw.survival.service.Market;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Market.LogisticsBean;
import tw.survival.model.Market.LogisticsRepository;

@Service
@Transactional
public class LogisticsService {
	
	@Autowired
	private LogisticsRepository LogisticsDao;

	public LogisticsService() {

	}
	//c
	public void insertLogistics(LogisticsBean Logistics) {
		LogisticsDao.save(Logistics);
	}
	
	//r
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

	public List<LogisticsBean> findAllLogistics() {
		return LogisticsDao.findAll();
	}

	public LogisticsBean updatelog(LogisticsBean logBean) {
		LogisticsDao.save(logBean);
		return null;
	}
	
	//d
	public void deleteById(Integer id) {
		
	    LogisticsBean lb = findById(id);
	    lb.setInventory(null);
	    lb.setOrderItem(null);
	    lb.setPlayer(null);
	    LogisticsDao.deleteById(id);
	    return;
	}
}
