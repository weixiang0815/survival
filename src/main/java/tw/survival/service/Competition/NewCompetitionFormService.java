package tw.survival.service.Competition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
	 * @throws IOException 
	 */
	public NewCompetitionFormBean insert(NewCompetitionFormBean mainBean) throws IOException {
		NewCompetitionFormPart1Bean part1 = part1Dao.save(new NewCompetitionFormPart1Bean());
		mainBean.setFirstPart(part1);
		NewCompetitionFormPart2Bean part2 = part2Dao.save(new NewCompetitionFormPart2Bean());
		mainBean.setSecondPart(part2);
		NewCompetitionFormPart3Bean part3 = new NewCompetitionFormPart3Bean();
		String filepath = "C:/Survival/Competition/Competition/temp_content/";
		File file = new File(filepath);
		if (!file.exists()) {
			file.mkdirs();
		}
		part3 = part3Dao.save(part3);
		file = new File(filepath + "/temp_" + part3.getId());
		if (!file.exists()) {
			file.createNewFile();
		}
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
		if (optional.isPresent()) {
			NewCompetitionFormBean form = optional.get();
			StringBuilder content = new StringBuilder("");
			try (
					FileInputStream fis = new FileInputStream(form.getThirdPart().getContentFileLocation());
					InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
					BufferedReader br = new BufferedReader(isr);
					) {
				String line = "";
				while((line = br.readLine()) != null) {
					content.append(line + "\n\n");
				}
				form.getThirdPart().setContent(content.toString());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return form;
		}
		return null;
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
			NewCompetitionFormBean form = mainDao.findByCreator(creatorId, creatorType);
			StringBuilder content = new StringBuilder("");
			try (
					FileInputStream fis = new FileInputStream(form.getThirdPart().getContentFileLocation());
					InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
					BufferedReader br = new BufferedReader(isr);
					) {
				String line = "";
				while((line = br.readLine()) != null) {
					content.append(line + "\n\n");
				}
				form.getThirdPart().setContent(content.toString());
			}
			return form;
		} catch (Exception e) {
			e.printStackTrace();
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
			NewCompetitionFormBean form = mainDao.findFirstByOrderByLastEditedDesc();
			StringBuilder content = new StringBuilder("");
			try (
					FileInputStream fis = new FileInputStream(form.getThirdPart().getContentFileLocation());
					InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
					BufferedReader br = new BufferedReader(isr);
					) {
				String line = "";
				while((line = br.readLine()) != null) {
					content.append(line + "\n\n");
				}
				form.getThirdPart().setContent(content.toString());
			}
			return form;
		} catch (Exception e) {
			e.printStackTrace();
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
		List<NewCompetitionFormBean> forms = mainDao.findAll();
		forms.forEach(form -> {
			StringBuilder content = new StringBuilder("");
			try (
					FileInputStream fis = new FileInputStream(form.getThirdPart().getContentFileLocation());
					InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
					BufferedReader br = new BufferedReader(isr);
					) {
				String line = "";
				while((line = br.readLine()) != null) {
					content.append(line + "\n\n");
				}
				form.getThirdPart().setContent(content.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return forms;
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
			String filepath = thirdPart.getContentFileLocation();
			File file = new File(filepath);
			file.delete();
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
			String filepath = thirdPart.getContentFileLocation();
			File file = new File(filepath);
			file.delete();
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
			if (mainForm.getFirstPart().getStartDate().trim().length() == 0) {				
				firstPart.setStartDate(null);
			} else {				
				firstPart.setStartDate(mainForm.getFirstPart().getStartDate());
			}
			if (mainForm.getFirstPart().getEndDate().trim().length() == 0) {				
				firstPart.setEndDate(null);
			} else {
				firstPart.setEndDate(mainForm.getFirstPart().getEndDate());				
			}
			NewCompetitionFormPart3Bean thirdPart = form.getThirdPart();
			try (
					FileOutputStream fos = new FileOutputStream(thirdPart.getContentFileLocation());
					OutputStreamWriter osw = new OutputStreamWriter(fos);
					PrintWriter pw = new PrintWriter(osw);
					) {
				pw.println(mainForm.getThirdPart().getContent());
			} catch (Exception e) {
				e.printStackTrace();
			}
			form.setLastEdited(new Date());
			return mainDao.save(form);
		} else {
			return null;
		}
	}

}