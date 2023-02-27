package tw.survival.controller.Place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tw.survival.model.Place.ScheduleBean;
import tw.survival.service.Competition.CompetitionToScheduleService;
import tw.survival.service.Place.PlaceService;
import tw.survival.service.Place.ScheduleService;

@Controller
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private PlaceService placeService;
	
	@Autowired
	private CompetitionToScheduleService CTSService;

	@GetMapping("/schedule/new")
	public String newSchedule(Model model) {
		model.addAttribute("schedule", new ScheduleBean());
		model.addAttribute("placeList", placeService.getAllPlace());
		model.addAttribute("ctsList", CTSService.findAll());
		return "Place/addSchedule";
	}

}