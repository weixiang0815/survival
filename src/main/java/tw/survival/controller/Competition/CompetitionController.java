package tw.survival.controller.Competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.service.Competition.CompetitionPictureService;
import tw.survival.service.Competition.CompetitionPrizeService;
import tw.survival.service.Competition.CompetitionService;
import tw.survival.service.Competition.SignUpService;

@Controller
public class CompetitionController {

	@Autowired
	private CompetitionService compService;

	@Autowired
	private CompetitionPrizeService compPrizeService;

	@Autowired
	private CompetitionPictureService compPicService;

	@Autowired
	private SignUpService signupService;

	/**
	 * 跳轉至活動系統首頁
	 * 
	 * @author 王威翔
	 */
	@GetMapping("/competition")
	public String main() {
		return "Competition/index";
	}

	/**
	 * 跳轉至新增活動頁面
	 * 
	 * @author 王威翔
	 */
	@GetMapping("/competition/new")
	public String newCompetition(Model model) {
		model.addAttribute("competition", new CompetitionBean());
		return "Competition/newCompetition";
	}

	/**
	 * 新增一筆活動實體，但不一定直接發布
	 * 
	 * @return 重新導向至活動系統首頁
	 * @author 王威翔
	 */
	@PostMapping("/competition/create")
	public String createCompetition(@ModelAttribute("competitionBean") CompetitionBean comp, BindingResult result,
			Model model) {
		model.addAttribute("competition", comp);
		return "redirect:/competition";
	}

	/**
	 * 正式發布一筆活動資訊
	 * 
	 * @return 重新導向至活動系統首頁
	 * @author 王威翔
	 */
	@GetMapping("/competition/publish")
	public String publishCompetition() {
		return "redirect:/competition";
	}

	/**
	 * 跳轉至搜尋活動資訊頁面
	 * 
	 * @author 王威翔
	 */
	@GetMapping("/competition/search")
	public String searchCompetition() {
		return "Competition/searchCompetition";
	}

	/**
	 * 透過 id 跳轉至該活動詳情頁面
	 * 
	 * @author 王威翔
	 */
	@GetMapping("/competition/detail")
	public String competitionDetailById() {
		return "Competition/competitionDetail";
	}

	/**
	 * 跳轉至多筆活動資訊搜尋結果頁面
	 * 
	 * @author 王威翔
	 */
	@GetMapping("/competition/search/result")
	public String searchAll(Model model) {
		model.addAttribute("compList", compService.findAll());
		return "Competition/showCompetitions";
	}

	/**
	 * 透過 id 跳轉至該活動資訊編輯頁面
	 * 
	 * @author 王威翔
	 */
	@GetMapping("/competition/edit")
	public String editCompetition(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("comp", compService.findById(id));
		return "Competition/editCompetition";
	}

	/**
	 * 透過 id 更新一筆活動資訊
	 * 
	 * @return 重新導向至該活動詳情頁面
	 * @author 王威翔
	 */
	@PutMapping("/competition/edit/send")
	public String editCompetitionById() {
		return "redirect:/competition/detail";
	}

	/**
	 * 透過 id 刪除一筆活動資訊
	 * 
	 * @return 重新導向至多筆活動資訊搜尋結果
	 * @author 王威翔
	 */
	@DeleteMapping("/competition/delete")
	public String deleteCompetitionById(@RequestParam("id") Integer id) {
		return "redirect:/competition/search/result";
	}

	/**
	 * 透過 id 將一筆活動資訊下架，但不一定直接刪除
	 * 
	 * @return 重新導向至多筆活動資訊搜尋結果
	 * @author 王威翔
	 */
	@GetMapping("/competition/takedown")
	public String takedownCompetitionById() {
		return "redirect:/competition/search/result";
	}

}