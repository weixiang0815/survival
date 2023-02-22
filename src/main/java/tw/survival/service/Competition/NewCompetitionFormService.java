package tw.survival.service.Competition;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.NewCompetitionFormBean;
import tw.survival.model.Competition.NewCompetitionFormPart1Bean;
import tw.survival.model.Competition.NewCompetitionFormPart1Repository;
import tw.survival.model.Competition.NewCompetitionFormPart2Bean;
import tw.survival.model.Competition.NewCompetitionFormPart2Repository;
import tw.survival.model.Competition.NewCompetitionFormPart3Bean;
import tw.survival.model.Competition.NewCompetitionFormPart3Repository;
import tw.survival.model.Competition.NewCompetitionFormRepository;

@Service
@Transactional
public class NewCompetitionFormService {

	@Autowired
	private NewCompetitionFormRepository mainDao;

	@Autowired
	private NewCompetitionFormPart1Repository part1Dao;

	@Autowired
	private NewCompetitionFormPart2Repository part2Dao;

	@Autowired
	private NewCompetitionFormPart3Repository part3Dao;

	/**
	 * 新建一筆活動新增表單暫存實體
	 * 
	 * @param comp 欲新建的活動新增表單暫存實體
	 * @return 新建成功回傳活動新增表單暫存實體，失敗回傳 null
	 * @author 王威翔
	 */
	public NewCompetitionFormBean insert(NewCompetitionFormBean mainBean) {
		NewCompetitionFormPart1Bean part1 = part1Dao.save(new NewCompetitionFormPart1Bean());
		mainBean.setFirstPart(part1);
		NewCompetitionFormPart2Bean part2 = part2Dao.save(new NewCompetitionFormPart2Bean());
		mainBean.setSecondPart(part2);
		NewCompetitionFormPart3Bean part3 = part3Dao.save(new NewCompetitionFormPart3Bean());
		mainBean.setThirdPart(part3);
		return mainDao.save(mainBean);
	}

	/**
	 * 透過 id 查詢一筆活動新增表單暫存實體
	 * 
	 * @param id 欲查詢的活動新增表單暫存實體 id
	 * @return 查詢成功回傳該活動新增表單暫存實體，查無資料回傳 null
	 * @author 王威翔
	 */
	public NewCompetitionFormBean findById(Integer id) {
		Optional<NewCompetitionFormBean> optional = mainDao.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	/**
	 * 透過創作者 id 查詢一筆活動新增表單暫存實體
	 * 
	 * @param creatorId   欲查詢活動新增表單暫存實體的創作者 id
	 * @param creatorType 若創作者為會員應傳入整數 1，員工則整數 2
	 * @return 查詢成功回傳該活動新增表單暫存實體，否則回傳 null
	 * @author 王威翔
	 */
	public NewCompetitionFormBean findByCreator(Integer creatorId, Integer creatorType) {
		try {
			return mainDao.findByCreator(creatorId, creatorType);
		} catch (Exception e) {
			System.out.println("something went wrong");
			return null;
		}
	}

	/**
	 * 回傳最新建立的活動新增表單暫存實體
	 * 
	 * @return 查詢成功回傳該活動新增表單暫存實體，否則回傳 null
	 * @author 王威翔
	 */
	public NewCompetitionFormBean findLatestCreated() {
		try {
			return mainDao.findFirstByOrderByLastEditedDesc();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查詢至今所有創建過的活動新增表單暫存實體
	 * 
	 * @return 裝有所有活動新增表單暫存實體的 List 物件
	 * @author 王威翔
	 */
	public List<NewCompetitionFormBean> findAll() {
		return mainDao.findAll();
	}

	/**
	 * 透過 id 刪除一筆活動新增表單暫存實體紀錄
	 * 
	 * @param id 欲刪除紀錄的活動新增表單暫存實體 id
	 * @return 刪除成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean deleteById(Integer id) {
		try {
			NewCompetitionFormBean mainForm = mainDao.findById(id).get();
			NewCompetitionFormPart1Bean firstPart = mainForm.getFirstPart();
			mainForm.setFirstPart(null);
			NewCompetitionFormPart2Bean secondPart = mainForm.getSecondPart();
			mainForm.setSecondPart(null);
			NewCompetitionFormPart3Bean thirdPart = mainForm.getThirdPart();
			mainForm.setThirdPart(null);
			part1Dao.delete(firstPart);
			part2Dao.delete(secondPart);
			part3Dao.delete(thirdPart);
			mainDao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 透過實體刪除一筆活動新增表單暫存實體紀錄
	 * 
	 * @param mainForm 欲刪除紀錄的活動新增表單暫存實體
	 * @return 刪除成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean deleteByEntity(NewCompetitionFormBean mainForm) {
		try {
			NewCompetitionFormPart1Bean firstPart = mainForm.getFirstPart();
			mainForm.setFirstPart(null);
			NewCompetitionFormPart2Bean secondPart = mainForm.getSecondPart();
			mainForm.setSecondPart(null);
			NewCompetitionFormPart3Bean thirdPart = mainForm.getThirdPart();
			mainForm.setThirdPart(null);
			part1Dao.delete(firstPart);
			part2Dao.delete(secondPart);
			part3Dao.delete(thirdPart);
			mainDao.delete(mainForm);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 更新一筆活動新增表單暫存實體紀錄
	 * 
	 * @param mainForm 欲更新內容的活動新增表單暫存實體紀錄
	 * @return 更新成功回傳該活動新增表單暫存實體紀錄，拋出錯誤回傳 null
	 * @author 王威翔
	 */
	public NewCompetitionFormBean updateByEntity(NewCompetitionFormBean mainForm) {
		Optional<NewCompetitionFormBean> optional = mainDao.findById(mainForm.getId());
		if (optional.isPresent()) {
			NewCompetitionFormBean form = optional.get();
			NewCompetitionFormPart1Bean firstPart = form.getFirstPart();
			firstPart.setMandarinName(mainForm.getFirstPart().getMandarinName());
			firstPart.setEnglishName(mainForm.getFirstPart().getEnglishName());
			firstPart.setStartDate(mainForm.getFirstPart().getStartDate());
			firstPart.setStartTimespan(mainForm.getFirstPart().getStartTimespan());
			firstPart.setEndDate(mainForm.getFirstPart().getEndDate());
			firstPart.setEndTimespan(mainForm.getFirstPart().getEndTimespan());
			NewCompetitionFormPart2Bean secondPart = form.getSecondPart();
			secondPart.setStatus(mainForm.getSecondPart().getStatus());
			secondPart.setSingleOrCrew(mainForm.getSecondPart().getSingleOrCrew());
			secondPart.setPlaceId(mainForm.getSecondPart().getPlaceId());
			secondPart.setBudget(mainForm.getSecondPart().getBudget());
			secondPart.setCapacity(mainForm.getSecondPart().getCapacity());
			secondPart.setFee(mainForm.getSecondPart().getFee());
			NewCompetitionFormPart3Bean thirdPart = form.getThirdPart();
			thirdPart.setContent(mainForm.getThirdPart().getContent());
			form.setLastEdited(new Date());
			return mainDao.save(form);
		} else {
			return null;
		}
	}

}