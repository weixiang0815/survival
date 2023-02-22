package tw.survival.controller.Competition;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.model.Competition.NewCompetitionFormBean;
import tw.survival.service.Competition.CompetitionService;
import tw.survival.service.Competition.NewCompetitionFormService;
import tw.survival.service.Employee.EmployeeService;
import tw.survival.service.Player.PlayerService;

@RestController
public class CompetitionControllerAjax {

	@Autowired
	private NewCompetitionFormService newFormService;

	@Autowired
	private CompetitionService compService;

	@Autowired
	private PlayerService playerService;

	@Autowired
	private EmployeeService employeeService;

	/**
	 * 用 AJAX 取得使用者先前的填表紀錄，若查無資料則創建新的活動新增表單暫存紀錄實體
	 * 
	 * @param creatorId   登入使用者 id
	 * @param creatorType 使用者型態，會員為 1，員工為 2
	 * @return 回傳該活動新增表單暫存紀錄實體
	 * @author 王威翔
	 */
	@PostMapping("/competition/api/create/newForm/getlatest")
	public NewCompetitionFormBean getLatestNewCompetitionForm(@RequestBody NewCompetitionFormBean form) {
		NewCompetitionFormBean latestForm = newFormService.findByCreator(form.getCreatorId(), form.getCreatorType());
		if (latestForm == null) {
			NewCompetitionFormBean newForm = new NewCompetitionFormBean();
			newForm.setCreatorId(form.getCreatorId());
			newForm.setCreatorType(form.getCreatorType());
			latestForm = newFormService.insert(newForm);
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
	public String createCompetition() {
		return "新增成功";
	}

	/**
	 * 用 AJAX 正式發布一筆活動資訊
	 * 
	 * @return 發布成功與否
	 * @author 王威翔
	 */
	@GetMapping("/competition/api/publish")
	public String publishCompetition() {
		return "發布成功";
	}

	/**
	 * 用 AJAX 獲得指定 id 活動實體
	 * 
	 * @return 回傳查到的指定 id 活動實體
	 * @author 王威翔
	 */
	@GetMapping("/competition/api/")
	public CompetitionBean competitionDetailById() {
		return new CompetitionBean();
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
	 * 用 AJAX 更新一筆活動資訊
	 * 
	 * @return 更新成功與否
	 * @author 王威翔
	 */
	@PutMapping("/competition/api/edit")
	public String editCompetitionById() {
		return "更新成功";
	}

	/**
	 * 用 AJAX 刪除指定 id 活動資訊
	 * 
	 * @return 刪除成功與否
	 * @author 王威翔
	 */
	@DeleteMapping("/competition/api/delete")
	public String deleteCompetitionById() {
		return "刪除成功";
	}

	/**
	 * 用 AJAX 下架指定 id 活動資訊，但不一定直接刪除
	 * 
	 * @return 下架成功與否
	 * @author 王威翔
	 */
	@GetMapping("/competition/api/takedown")
	public String takedownCompetitionById() {
		return "已下架";
	}

}