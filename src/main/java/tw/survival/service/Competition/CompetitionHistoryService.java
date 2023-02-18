package tw.survival.service.Competition;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.CompetitionHistoryBean;
import tw.survival.model.Competition.CompetitionHistoryRepository;

@Service
@Transactional
public class CompetitionHistoryService {

	@Autowired
	private CompetitionHistoryRepository compHistoryDao;

	/**
	 * 新建一筆對戰紀錄
	 * 
	 * @param comp 欲新建的對戰紀錄實體
	 * @return 新建成功回傳對戰紀錄實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionHistoryBean create(CompetitionHistoryBean compHistory) {
		try {
			// 要先給一些欄位加入預設值
			return compHistoryDao.save(compHistory);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 透過 id 查詢一筆對戰紀錄實體
	 * 
	 * @param id 欲查詢的對戰紀錄 id
	 * @return 查詢成功回傳該對戰紀錄實體，查無資料回傳 null
	 * @author 王威翔
	 */
	public CompetitionHistoryBean findById(Integer id) {
		Optional<CompetitionHistoryBean> optional = compHistoryDao.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	/**
	 * 查詢至今所有創建過的對戰紀錄實體
	 * 
	 * @return 裝有所有對戰紀錄實體的 List 物件
	 * @author 王威翔
	 */
	public List<CompetitionHistoryBean> findAll() {
		return compHistoryDao.findAll();
	}

	/**
	 * 透過 id 刪除一筆對戰紀錄
	 * 
	 * @param id 欲刪除的對戰紀錄實體 id
	 * @return 刪除成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean deleteById(Integer id) {
		try {
			compHistoryDao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 透過實體刪除一筆對戰紀錄
	 * 
	 * @param comp 欲刪除的對戰紀錄實體
	 * @return 刪除成功回傳 true，失敗回傳 false
	 */
	public boolean deleteByEntity(CompetitionHistoryBean compHistory) {
		try {
			compHistoryDao.delete(compHistory);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 更新一筆對戰紀錄實體
	 * 
	 * @param comp 欲更新內容的對戰紀錄實體
	 * @return 更新成功回傳該對戰紀錄實體，拋出錯誤回傳 null
	 * @author 王威翔
	 */
	public CompetitionHistoryBean updateByEntity(CompetitionHistoryBean compHistory) {
		if (compHistoryDao.findById(compHistory.getCompetitionId()).isPresent()) {
			try {
				return compHistoryDao.save(compHistory);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}

}