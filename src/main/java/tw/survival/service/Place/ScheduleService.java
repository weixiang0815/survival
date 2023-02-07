package tw.survival.service.Place;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Place.ScheduleBean;
import tw.survival.model.Place.ScheduleRepository;

@Service
@Transactional
public class ScheduleService {

	@Autowired
	private ScheduleRepository sDAO;
	
	public ScheduleService() {

	}

	public ScheduleBean insertSchedule(ScheduleBean schedule) {
		return sDAO.save(schedule);
	}
	
	public ScheduleBean getOneScheduleById(Integer id) {
		Optional<ScheduleBean>  optional = sDAO.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public List<ScheduleBean> getAllSchedule(){
		return sDAO.findAll();
	}
	
	public void deleteScheduleById(Integer id) {
		 sDAO.deleteById(id);
	}
	
	public ScheduleBean updateSchedule(ScheduleBean schedule) {
		return sDAO.save(schedule);
	}
}
