package tw.survival.controller.front.R.Competition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.service.Competition.CompetitionService;

@Controller
@RequestMapping("/front")
@SessionAttributes({ "player", "employee" })
public class CompetitionControllerFrontR {

	@Autowired
	private CompetitionService compService;

	@GetMapping("/competition")
	public String goIndex() {
		return "front/Competition/index";
	}

	@GetMapping("/signup")
	public String goSignup() {
		return "front/Competition/signup";
	}

	@GetMapping("/competition/detail/{id}")
	public String goCompDetail(@PathVariable Integer id, Model model) {
		CompetitionBean comp = compService.findById(id);
		model.addAttribute("comp", comp);
		return "front/Competition/compDetail";
	}

	@GetMapping("/competition/photo/{id}")
	public String goCompPhoto(@PathVariable Integer id, Model model) {
		CompetitionBean comp = compService.findById(id);
		model.addAttribute("comp", comp);
		return "front/Competition/photo";
	}

	@GetMapping("/competition/history")
	public String goCompHistory() {
		return "front/Competition/history";
	}

	@GetMapping("/competition/show")
	public String goShow(Model model) {
		List<CompetitionBean> comps = compService.findAll();
		model.addAttribute("comps", comps);
		return "front/Competition/showCompetitions";
	}

}