package tw.survival.controller.Place;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import tw.survival.model.Place.ScheduleBean;
import tw.survival.service.Place.PlaceService;
import tw.survival.service.Place.ScheduleService;

@Controller
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private PlaceService placeService;
	
	@GetMapping("/schedule/new")
	public String newSchedule(Model model) {
		model.addAttribute("schedule", new ScheduleBean());
		model.addAttribute("placeList", placeService.getAllPlace());
		return "Place/addSchedule";
	}
	
}
