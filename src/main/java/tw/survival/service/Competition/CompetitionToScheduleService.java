package tw.survival.service.Competition;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.survival.model.Competition.CompetitionToScheduleBean;
import tw.survival.model.Competition.CompetitionToScheduleRepository;

@Service
@Transactional
public class CompetitionToScheduleService {

	@Autowired
	private CompetitionToScheduleRepository compToScheduleRepo;

	/**
	 * 新增一筆活動時程中介表實體
	 * 
	 * @param compToSchedule 欲新增的活動時程中介表實體
	 * @return 新增成功回傳該實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionToScheduleBean insert(CompetitionToScheduleBean compToSchedule) {
		try {
			return compToScheduleRepo.save(compToSchedule);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 透過 id 查詢活動時程中介表實體
	 * 
	 * @param id 欲查詢的活動時程中介表實體 id
	 * @return 查詢成功回傳該活動時程中介表實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionToScheduleBean findById(Integer id) {
		Optional<CompetitionToScheduleBean> optional = compToScheduleRepo.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	/**
	 * 回傳至今所有活動時程中介表實體
	 * 
	 * @return 回傳裝著活動時程中介表實體的 List 物件
	 * @author 王威翔
	 */
	public List<CompetitionToScheduleBean> findAll() {
		return compToScheduleRepo.findAll();
	}

	/**
	 * 透過 id 刪除一筆活動時程中介表實體
	 * 
	 * @param id 欲刪除的活動中介表實體 id
	 * @return 刪除成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean deleteById(Integer id) {
		try {
			compToScheduleRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 透過實體刪除一筆活動時程中介表實體
	 * 
	 * @param compToSchedule 欲刪除的活動時程中介表實體
	 * @return 刪除成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean deleteByEntity(CompetitionToScheduleBean compToSchedule) {
		try {
			compToScheduleRepo.delete(compToSchedule);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}