package tw.survival.service.Competition;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.CompetitionPrizeBean;
import tw.survival.model.Competition.CompetitionPrizeRepository;

@Service
@Transactional
public class CompetitionPrizeService {

	@Autowired
	private CompetitionPrizeRepository competitionPrizeRepository;

	/**
	 * 新增一筆活動獎品紀錄
	 * 
	 * @param compPrize 欲新增的活動獎品實體
	 * @return 新增成功回傳該活動獎品實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionPrizeBean insert(CompetitionPrizeBean compPrize) {
		try {
			return competitionPrizeRepository.save(compPrize);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 透過 id 查詢一筆活動獎品實體
	 * 
	 * @param id 欲查詢的活動獎品實體 id
	 * @return 查詢成功回傳該活動獎品實體，查無資料回傳 null
	 * @author 王威翔
	 */
	public CompetitionPrizeBean findById(Integer id) {
		Optional<CompetitionPrizeBean> optional = competitionPrizeRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	/**
	 * 查詢至今所有活動獎品紀錄
	 * 
	 * @return 回傳裝有所有活動獎品實體的 List 物件
	 * @author 王威翔
	 */
	public List<CompetitionPrizeBean> findAll() {
		return competitionPrizeRepository.findAll();
	}

	/**
	 * 透過 id 刪除一筆活動獎品紀錄
	 * 
	 * @param id 欲刪除紀錄的活動獎品實體 id
	 * @return 刪除成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean deleteById(Integer id) {
		try {
			competitionPrizeRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 更新一筆活動獎品實體
	 * 
	 * @param compPrize 欲更新內容的活動獎品實體
	 * @return 更新成功回傳該活動獎品實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionPrizeBean updateByEntity(CompetitionPrizeBean compPrize) {
		try {
			competitionPrizeRepository.save(compPrize);
			return compPrize;
		} catch (Exception e) {
			return null;
		}
	}
}