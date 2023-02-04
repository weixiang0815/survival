package tw.survival.model.Place;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ScheduleService {

	@Autowired
	private ScheduleDAO sDAO;
	
	public ScheduleService() {

	}

	public ScheduleBean addSchedule(ScheduleBean schedule) {
		return sDAO.addSchedule(schedule);
	}
	
	public ScheduleBean getOneScheduleById(Integer id) {
		return sDAO.getOneScheduleById(id);
	}
	
	public List<ScheduleBean> getAllSchedule(){
		return sDAO.getAllSchedule();
	}
	
	public String deleteScheduleById(Integer id) {
		return sDAO.deleteScheduleById(id);
	}
	
	public boolean updateSchedule(ScheduleBean schedule) {
		return sDAO.updateSchedule(schedule);
	}
}
