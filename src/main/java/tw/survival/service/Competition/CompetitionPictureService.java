package tw.survival.service.Competition;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.CompetitionPictureBean;
import tw.survival.model.Competition.CompetitionPictureRepository;

@Service
public class CompetitionPictureService {

	@Autowired
	private CompetitionPictureRepository competitionPictureRepository;

	/**
	 * 新建一張活動照片
	 * 
	 * @param compPicture 欲新增的活動照片實體
	 * @return 新增成功回傳該活動照片實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionPictureBean addPicture(CompetitionPictureBean compPicture) {
		try {
			return competitionPictureRepository.save(compPicture);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 透過 id 查詢一筆活動照片實體
	 * 
	 * @param id 欲查詢的活動照片實體 id
	 * @return 查詢成功回傳該活動照片實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionPictureBean findById(Integer id) {
		Optional<CompetitionPictureBean> optional = competitionPictureRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	/**
	 * 查詢至今所有活動照片實體
	 * 
	 * @return 回傳裝著所有活動照片實體的 List 物件
	 * @author 王威翔
	 */
	public List<CompetitionPictureBean> findAll() {
		return competitionPictureRepository.findAll();
	}

	/**
	 * 透過 id 刪除一張活動照片
	 * 
	 * @param id 欲刪除的活動照片實體 id
	 * @return 刪除成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean deletePictureById(Integer id) {
		try {
			competitionPictureRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 透過實體刪除一張活動照片
	 * 
	 * @param compPicture 欲刪除的活動照片實體
	 * @return 刪除成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean deletePictureByEntity(CompetitionPictureBean compPicture) {
		try {
			competitionPictureRepository.delete(compPicture);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 更新一筆活動照片實體
	 * 
	 * @param compPicture 欲更新的活動照片實體
	 * @return 更新成功回傳該活動照片實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionPictureBean updateByEntity(CompetitionPictureBean compPicture) {
		if (competitionPictureRepository.findById(compPicture.getId()).isPresent()) {
			try {
				return competitionPictureRepository.save(compPicture);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}

}