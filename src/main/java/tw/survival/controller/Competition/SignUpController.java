package tw.survival.controller.Competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import tw.survival.model.Competition.SignUpBean;
import tw.survival.service.Competition.CompetitionService;
import tw.survival.service.Competition.SignUpService;
import tw.survival.service.Place.PlaceService;

@Controller
public class SignUpController {
	
	@Autowired
	private SignUpService signupService;
	
	@Autowired
	private CompetitionService compService;
	
	@Autowired
	private PlaceService placeService;

	/**
	 * 跳轉至報名頁面
	 * 
	 * @author 王威翔
	 */
	@GetMapping("/competition/signup")
	public String newSignup(Model model) {
		model.addAttribute("signup", new SignUpBean());
		model.addAttribute("compList", compService.findAll());
		return "Competition/newSignup";
	}

	/**
	 * 新增一筆報名紀錄，但不一定已付款
	 * 
	 * @return 重新導向至活動系統首頁
	 * @author 王威翔
	 */
	@PostMapping("/competition/signup/create")
	public String createSignup(@ModelAttribute("signup") SignUpBean signup, Model model) {
		return "redirect:/competition";
	}

	/**
	 * 繳交報名費
	 * 
	 * @return 重新導向至活動系統首頁
	 * @author 王威翔
	 */
	@GetMapping("/competition/signup/payup")
	public String payupSignup() {
		return "redirect:/competition";
	}

	/**
	 * 跳轉至搜尋報名紀錄頁面
	 * 
	 * @author 王威翔
	 */
	@GetMapping("/competition/signup/search")
	public String searchSignup() {
		return "Competition/searchSignup";
	}

	/**
	 * 透過 id 跳轉至該報名紀錄詳情頁面
	 * 
	 * @author 王威翔
	 */
	@GetMapping("/competition/signup/detail")
	public String signupDetailById() {
		return "Competition/signupDetail";
	}

	/**
	 * 跳轉至多筆報名紀錄搜尋結果頁面
	 * 
	 * @author 王威翔
	 */
	@GetMapping("/competition/signup/search/result")
	public String searchAll() {
		return "Competition/showSignups";
	}

	/**
	 * 透過 id 跳轉至該報名紀錄編輯頁面
	 * 
	 * @author 王威翔
	 */
	@GetMapping("/competition/signup/edit")
	public String editSignup() {
		return "Competition/editSignup";
	}

	/**
	 * 透過 id 更新一筆報名紀錄
	 * 
	 * @return 重新導向至該報名紀錄詳情頁面
	 * @author 王威翔
	 */
	@PutMapping("/competition/signup/edit/send")
	public String editSignupById() {
		return "redirect:/competition/signup/detail";
	}

	/**
	 * 透過 id 刪除一筆報名紀錄
	 * 
	 * @return 重新導向至多筆報名紀錄搜尋結果
	 * @author 王威翔
	 */
	@DeleteMapping("/competition/signup/delete")
	public String deleteSignupById() {
		return "redirect:/competition/signup/search/result";
	}

}