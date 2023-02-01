package tw.survival.controller.Competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tw.survival.model.Competition.CompetitionService;

@Controller
public class CompetitionController {

	@Autowired
	private CompetitionService cService;

}