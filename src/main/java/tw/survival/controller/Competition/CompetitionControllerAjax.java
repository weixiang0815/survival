package tw.survival.controller.Competition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.service.Competition.CompetitionHistoryService;
import tw.survival.service.Competition.CompetitionPictureService;
import tw.survival.service.Competition.CompetitionPrizeService;
import tw.survival.service.Competition.CompetitionService;
import tw.survival.service.Competition.SignUpService;

@RestController
public class CompetitionControllerAjax {

	@Autowired
	private CompetitionService compService;

	@Autowired
	private CompetitionPrizeService compPrizeService;

	@Autowired
	private CompetitionPictureService compPicService;

	@Autowired
	private CompetitionHistoryService compHistoryService;

	@Autowired
	private SignUpService signupService;

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