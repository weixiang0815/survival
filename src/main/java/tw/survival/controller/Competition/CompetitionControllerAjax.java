package tw.survival.controller.Competition;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.model.Competition.CompetitionSearchCondititonsDto;
import tw.survival.model.Competition.NewCompetitionFormBean;
import tw.survival.service.Competition.CompetitionPictureService;
import tw.survival.service.Competition.CompetitionService;
import tw.survival.service.Competition.NewCompetitionFormService;

@RestController
public class CompetitionControllerAjax {

	@Autowired
	private NewCompetitionFormService newFormService;

	@Autowired
	private CompetitionService compService;

	@Autowired
	private CompetitionPictureService compPictureService;

	/**
	 * 用 AJAX 取得使用者先前的填表紀錄，若查無資料則創建新的活動新增表單暫存紀錄實體
	 * 
	 * @param creatorId   登入使用者 id
	 * @param creatorType 使用者型態，會員為 1，員工為 2
	 * @return 回傳該活動新增表單暫存紀錄實體
	 * @author 王威翔
	 * @throws IOException
	 */
	@PostMapping("/competition/api/create/newForm/getlatest")
	public NewCompetitionFormBean getLatestNewCompetitionForm(@RequestBody NewCompetitionFormBean form)
			throws IOException {
		NewCompetitionFormBean latestForm = newFormService.findByCreator(form.getCreatorId(), form.getCreatorType());
		if (latestForm == null) {
			NewCompetitionFormBean newForm = new NewCompetitionFormBean();
			newForm.setCreatorId(form.getCreatorId());
			newForm.setCreatorType(form.getCreatorType());
			latestForm = newFormService.insert(newForm);
			String filepath = "C:/Survival/Competition/Competition/temp_content/";
			File file = new File(filepath);
			if (!file.exists()) {
				file.mkdirs();
			}
			filepath += "temp_" + latestForm.getThirdPart().getId() + ".txt";
			file = new File(filepath);
			if (!file.exists()) {
				file.createNewFile();
			}
			latestForm.getThirdPart().setContentFileLocation(filepath);
		}
		return latestForm;
	}

	/**
	 * 用 AJAX 更新一筆活動新增表單暫存實體
	 * 
	 * @param newForm 欲更新的活動新曾表單暫存實體
	 * @author 王威翔
	 */
	@PutMapping("/competition/api/create/update")
	public Date updateNewCompetitionForm(@RequestBody NewCompetitionFormBean newForm) {
		return newFormService.updateByEntity(newForm).getLastEdited();
	}

	/**
	 * 用 AJAX 新增一筆活動實體，但不一定直接發布
	 * 
	 * @return 新增成功與否
	 * @author 王威翔
	 */
	@PostMapping("/competition/api/create")
	public String createCompetition(@RequestBody CompetitionBean comp) {
		compService.create(comp);
		return "新增成功";
	}

	/**
	 * 用 AJAX 正式發布一筆活動資訊
	 * 
	 * @param id 欲發布的活動實體 id
	 * @return 發布成功與否
	 * @author 王威翔
	 */
	@GetMapping("/competition/api/publish/{id}")
	public String publishCompetition(@PathVariable Integer id) {
		return compService.publishById(id) != null ? "發布成功" : "發布失敗";
	}

	/**
	 * 用 AJAX 回傳最新一筆活動資訊
	 * 
	 * @return 回傳查到的最新一筆活動實體
	 * @author 王威翔
	 */
	@GetMapping("/competition/api/latest")
	public CompetitionBean latest() {
		return compService.findLatestCompetition();
	}

	/**
	 * 用 AJAX 獲得指定 id 活動實體
	 * 
	 * @param id 欲查詢的活動實體 id
	 * @return 回傳查到的指定 id 活動實體
	 * @author 王威翔
	 */
	@GetMapping("/competition/api/{id}")
	public CompetitionBean competitionDetailById(@PathVariable Integer id) {
		return compService.findById(id);
	}

	/**
	 * 用 AJAX 獲得指定 id 活動照片
	 * 
	 * @param id 欲獲得的指定 id 活動照片
	 * @return 回傳查到的指定 id 活動照片
	 * @author 王威翔
	 */
	@GetMapping("/competition/api/photo/{id}")
	public byte[] getCompPhoto(@PathVariable Integer id) {
		return compPictureService.findById(id).getPicture();
	}

	/**
	 * 用 AJAX 獲得裝有多筆活動實體的 List 物件
	 * 
	 * @return 回傳裝有多筆活動實體的 List 物件
	 * @author 王威翔
	 */
	@GetMapping("/competition/api/search/result")
	public List<CompetitionBean> searchAll() {
		return new ArrayList<>();
	}

	/**
	 * 用 AJAX 進行多條件查詢活動
	 * 
	 * @param conditions 查詢依據的各種條件
	 * @return 裝著活動實體的 List 物件
	 * @author 王威翔
	 */
	@PostMapping("/competition/api/search/multicondition")
	public List<CompetitionBean> multiconditionSearch(@RequestBody CompetitionSearchCondititonsDto conditions) {
		return compService.multiconditionSearch(conditions);
	}

	/**
	 * 用 AJAX 更新一筆活動資訊
	 * 
	 * @return 更新成功與否
	 * @author 王威翔
	 */
	@PutMapping("/competition/api/edit")
	public String editCompetition(@RequestBody CompetitionBean comp) {
		compService.updateByEntity(comp);
		return "更新成功";
	}

	/**
	 * 用 AJAX 刪除指定 id 活動資訊
	 * 
	 * @param id 欲刪除的活動實體 id
	 * @return 刪除成功與否
	 * @author 王威翔
	 */
	@DeleteMapping("/competition/api/delete/{id}")
	public String deleteCompetitionById(@PathVariable Integer id) {
		return compService.deleteById(id) ? "刪除成功" : "刪除失敗";
	}

	/**
	 * 用 AJAX 下架指定 id 活動資訊，但不一定直接刪除
	 * 
	 * @param id 欲下架的活動實體 id
	 * @return 下架成功與否
	 * @author 王威翔
	 */
	@GetMapping("/competition/api/takedown/{id}")
	public String takedownCompetitionById(@PathVariable Integer id) {
		return compService.takedownById(id) != null ? "已下架" : "下架失敗";
	}

}