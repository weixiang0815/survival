package tw.survival.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "player", "employee" })
public class TemplateController {

	@GetMapping("/template/")
	public String goMain() {
		return "Template/index";
	}

	@GetMapping("/template/emp/sidebar")
	public String goEmployeeSidebar() {
		return "Template/Employee/main_sidebar";
	}

	@GetMapping("/template/player/sidebar")
	public String goPlayerSidebar() {
		return "Template/Employee/main_sidebar";
	}

}