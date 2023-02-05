package tw.survival.controller.Competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tw.survival.service.Competition.CompetitionService;

@Controller
public class CompetitionController {

	@Autowired
	private CompetitionService cService;

	@GetMapping("/competition")
	public String main() {
		return "Competition/index";
	}

	@GetMapping("/competition/add")
	public String newCompetition() {
		return "Competition/newCompetition";
	}

}