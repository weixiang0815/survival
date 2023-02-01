package tw.survival.model.Competition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompetitionService {

	@Autowired
	private CompetitionDAO cDAO;

	public CompetitionService() {
	}

	/**
	 * 新增一筆活動資料
	 * 
	 * @param comp 欲新增的 CompetitionBean
	 * 
	 * @return 回傳傳入的 CompetitionBean
	 */
	public CompetitionBean addCompetition(CompetitionBean comp) {
		return cDAO.addCompetition(comp);
	}

	/**
	 * 透過 CompetitionBean 刪除一筆活動資料
	 * 
	 * @param user 欲刪除資料的 CompetitionBean
	 * 
	 * @return 刪除成功回傳 true，否則回傳 false
	 */
	public boolean deleteCompetitionByBean(CompetitionBean comp) {
		return cDAO.deleteCompetitionByBean(comp);
	}

	/**
	 * 透過 id 刪除一筆活動資料
	 * 
	 * @param id 欲刪除資料的活動 id
	 * 
	 * @return 刪除成功回傳 true，否則回傳 false
	 */
	public String deleteCompetitionById(Integer id) {
		return cDAO.deleteCompetitionById(id);
	}

	/**
	 * 更新一筆活動資料
	 * 
	 * @param comp 傳入欲更新資料的活動 CompetitionBean
	 * 
	 * @return 更新成功回傳 true，否則回傳 false
	 */
	public boolean updateCompetition(CompetitionBean comp) {
		return cDAO.updateCompetition(comp);
	}

	/**
	 * 透過 id 查詢一筆活動資料
	 * 
	 * @param id 欲查詢資料的活動 id
	 * 
	 * @return 回傳查到的 CompetitionBean
	 */
	public CompetitionBean getOneCompetitionById(Integer id) {
		return cDAO.getOneCompetitionById(id);
	}

	/**
	 * 查詢所有活動資料
	 * 
	 * @return 回傳裝著所有 CompetitionBean 的列表
	 */
	public List<CompetitionBean> getAllCompetitions() {
		return cDAO.getAllCompetitions();
	}

}