package tw.survival.controller.Competition;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

	@GetMapping("/template/emp/sidebar")
	public String goEmployeeSidebar() {
		return "Template/Employee/main_sidebar";
	}
	
	@GetMapping("/template/player/sidebar")
	public String goPlayerSidebar() {
		return "Template/Employee/main_sidebar";
	}

}