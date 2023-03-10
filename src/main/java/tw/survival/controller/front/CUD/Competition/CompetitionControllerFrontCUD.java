package tw.survival.controller.front.CUD.Competition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.service.Competition.CompetitionService;

@Controller
@RequestMapping("/front/competition")
@SessionAttributes({ "player", "employee" })
public class CompetitionControllerFrontCUD {

	@Autowired
	private CompetitionService compService;

	@GetMapping("/signup")
	public String goSignUp(@RequestParam(value = "id", required = false) Integer id, Model model) {
		List<CompetitionBean> comps = compService.findAll();
		CompetitionBean comp = compService.findById(id);
		model.addAttribute("comps", comps);
		model.addAttribute("comp", comp);
		return "front/Competition/signup";
	}

}