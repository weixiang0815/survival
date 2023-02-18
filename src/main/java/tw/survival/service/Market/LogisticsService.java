package tw.survival.service.Market;

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
	
	public void insertLogistics(LogisticsBean Logistics) {
		LogisticsDao.save(Logistics);
	}
	
	public LogisticsBean getOneLogisticsById(Integer id) {
		Optional<LogisticsBean> optional = LogisticsDao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
}
