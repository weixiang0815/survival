package tw.survival.controller.Competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.model.Competition.CompetitionPrizeBean;
import tw.survival.model.Place.PlaceBean;
import tw.survival.service.Competition.CompetitionPrizeService;
import tw.survival.service.Competition.CompetitionService;
import tw.survival.service.Market.ProductService;
import tw.survival.service.Place.PlaceService;

@Controller
public class CompetitionController {

	@Autowired
	private CompetitionService compService;

	@Autowired
	private PlaceService placeService;

	@Autowired
	private CompetitionPrizeService compPrizeService;
	
	@Autowired
	private ProductService productService;

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
		model.addAttribute("placeList", placeService.getAllPlace());
		model.addAttribute("competition", new CompetitionBean());
		return "Competition/newCompetition";
	}

	/**
	 * 新增一筆活動實體，但不一定直接發布
	 * 
	 * @return 重新導向至活動詳情頁面
	 * @author 王威翔
	 */
	@PostMapping("/competition/create")
	public String createCompetition(@ModelAttribute("competition") CompetitionBean comp, Model model) {
		comp.setPlace(placeService.getOnePlaceById(comp.getPlaceId()));
		comp.setFounderEmployee(null);
		comp.setFounderPlayer(null);
		comp = compService.create(comp);
		if (comp.getStatus().contentEquals("已發布")) {
			compService.publishById(comp.getId());
		}
		model.addAttribute("comp", comp);
		return "redirect:/competition/detail?id=" + comp.getId();
	}

	/**
	 * 正式發布一筆活動資訊
	 * 
	 * @return 重新導向至活動詳情頁面
	 * @author 王威翔
	 */
	@GetMapping("/competition/publish")
	public String publishCompetition(@RequestParam("id") Integer id, Model model) {
		CompetitionBean comp = compService.publishById(id);
		model.addAttribute("comp", comp);
		return "Competition/competitionDetail";
	}

	/**
	 * 跳轉至新增活動獎品頁面
	 * 
	 * @param id 欲新增活獎品的活動 id
	 * @return 跳轉至新增活動獎品頁面
	 * @author 王威翔
	 */
	@GetMapping("/competition/prize/new")
	public String newPrizes(@RequestParam(value = "id", defaultValue = "1") Integer id, Model model) {
		CompetitionPrizeBean compPrize = new CompetitionPrizeBean();
		CompetitionBean comp = compService.findById(id);
		compPrize.setCompetitionId(id);
		compPrize.setCompetition(comp);
		model.addAttribute("prizes", compPrize);
		model.addAttribute("comp", comp);
		model.addAttribute("place", comp.getPlace());
		model.addAttribute("products", productService.findAllProduct());
		return "Competition/newCompPrize";
	}

	/**
	 * 新增指定活動 id 的獎品
	 * 
	 * @return 重新導向至指定 id 活動的詳情頁面
	 * @author 王威翔
	 */
	@GetMapping("/competition/prize/add")
	public String addPrizes(@ModelAttribute("compPrize") CompetitionPrizeBean compPrize, Model model) {
		compPrize = compPrizeService.insert(compPrize);
		CompetitionBean comp = compPrize.getCompetition();
		comp.setCompetitionPrizes(compPrize);
		return "redirect:/competition/detail?id=" + comp.getId();
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
	public String competitionDetailById(@RequestParam("id") Integer id, Model model) {
		CompetitionBean comp = compService.findById(id);
		int startTimespan = comp.getStartTimespan();
		String start = "";
		int endTimespan = comp.getEndTimespan();
		String end = "";
		switch (startTimespan) {
		case 1:
			start = "早上（6:00～12:00）";
			break;
		case 2:
			start = "下午（12:00～18:00）";
			break;
		case 3:
			start = "晚上（18:00～00:00）";
			break;
		case 4:
			start = "半夜（00:00～6:00）";
			break;
		}
		switch (endTimespan) {
		case 1:
			end = "早上（6:00～12:00）";
			break;
		case 2:
			end = "下午（12:00～18:00）";
			break;
		case 3:
			end = "晚上（18:00～00:00）";
			break;
		case 4:
			end = "半夜（00:00～6:00）";
			break;
		}
		PlaceBean place = comp.getPlace();
		model.addAttribute("place", place);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("comp", comp);
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
		CompetitionBean competition = compService.findById(id);
		model.addAttribute("competition", competition);
		model.addAttribute("placeList", placeService.getAllPlace());
		return "Competition/editCompetition";
	}

	/**
	 * 透過 id 更新一筆活動資訊
	 * 
	 * @return 重新導向至該活動詳情頁面
	 * @author 王威翔
	 */
	@PostMapping("/competition/edit/send")
	public String editCompetitionById(@ModelAttribute("competition") CompetitionBean comp, Model model) {
		compService.updateByEntity(comp);
		return "redirect:/competition/detail?id=" + comp.getId();
	}

	/**
	 * 透過 id 刪除一筆活動資訊
	 * 
	 * @return 重新導向至多筆活動資訊搜尋結果
	 * @author 王威翔
	 */
	@GetMapping("/competition/delete")
	public String deleteCompetitionById(@RequestParam("id") Integer id) {
		compService.deleteById(id);
		return "redirect:/competition/search/result";
	}

	/**
	 * 透過 id 將一筆活動資訊下架，但不一定直接刪除
	 * 
	 * @return 重新導向至活動詳情頁面
	 * @author 王威翔
	 */
	@GetMapping("/competition/takedown")
	public String takedownCompetitionById(@RequestParam("id") Integer id, Model model) {
		compService.takedownById(id);
		model.addAttribute("comp", compService.findById(id));
		return "Competition/competitionDetail";
	}

}