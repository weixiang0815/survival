package tw.survival.controller.Place;


import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import tw.survival.model.Place.ScheduleBean;
import tw.survival.service.Place.ScheduleService;

@Controller
public class ScheduleController {

	
	private ScheduleService sService;
	
	
	@GetMapping("/schedule/addSchedule")
	public String addPage(Model model) {
		model.addAttribute("scheduleBean", new ScheduleBean());
		return "Place/addSchedule";
	}
	
	
	@PostMapping("schedule/post")
	public String addPagePost(@ModelAttribute("scheduleBean") ScheduleBean sch ) {
		System.out.println("進入CONTROLLER");
		if(sch!=null) {
		sService.insertSchedule(sch);
		System.out.println("已儲存");
			
		}
		return "redirect:/place";
	}
}
