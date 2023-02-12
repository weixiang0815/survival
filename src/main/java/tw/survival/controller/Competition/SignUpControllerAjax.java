package tw.survival.controller.Competition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.survival.model.Competition.SignUpBean;
import tw.survival.service.Competition.CompetitionPictureService;
import tw.survival.service.Competition.CompetitionPrizeService;
import tw.survival.service.Competition.CompetitionService;
import tw.survival.service.Competition.SignUpService;

@RestController
public class SignUpControllerAjax {

	@Autowired
	private CompetitionService compService;

	@Autowired
	private CompetitionPrizeService compPrizeService;

	@Autowired
	private CompetitionPictureService compPicService;

	@Autowired
	private SignUpService signupService;

	/**
	 * 用 AJAX 新增一筆報名紀錄，但不一定已付款
	 * 
	 * @return 新增成功與否
	 * @author 王威翔
	 */
	@PostMapping("/competition/signup/api/create")
	public String createSignup() {
		return "新增成功";
	}

	/**
	 * 用 AJAX 繳交報名費
	 * 
	 * @return 繳費成功與否
	 * @author 王威翔
	 */
	@GetMapping("/competition/signup/api/publish")
	public String payupSignup() {
		return "發布成功";
	}

	/**
	 * 用 AJAX 獲得指定 id 報名紀錄
	 * 
	 * @return 回傳查到的指定 id 報名紀錄
	 * @author 王威翔
	 */
	@GetMapping("/competition/signup/api/")
	public SignUpBean signupDetailById() {
		return new SignUpBean();
	}

	/**
	 * 用 AJAX 獲得裝有多筆報名紀錄的 List 物件
	 * 
	 * @return 回傳裝有多筆報名紀錄的 List 物件
	 * @author 王威翔
	 */
	@GetMapping("/competition/signup/api/search/result")
	public List<SignUpBean> searchAll() {
		return new ArrayList<>();
	}

	/**
	 * 用 AJAX 更新一筆報名紀錄
	 * 
	 * @return 更新成功與否
	 * @author 王威翔
	 */
	@PutMapping("/competition/signup/api/edit")
	public String editSignUpById() {
		return "更新成功";
	}

	/**
	 * 用 AJAX 刪除指定 id 報名紀錄
	 * 
	 * @return 刪除成功與否
	 * @author 王威翔
	 */
	@DeleteMapping("/competition/signup/api/delete")
	public String deleteSignById() {
		return "刪除成功";
	}

}