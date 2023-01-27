package tw.survival.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(names = { "name" })
public class HelloController2 {

	@RequestMapping(path = "/hello2main.controller", method = RequestMethod.GET)
	public String processMainAction() {
		return "form";
	}

	@RequestMapping(path = "/hello2.controller", method = RequestMethod.GET)
	public String processAction(@RequestParam("name") String name, Model m, SessionStatus status) {
		// String name = request.getParameter("name");
		HashMap<String, String> errors = new HashMap<String, String>();
		// request.setAttribute("errors", errors);
		m.addAttribute("errors", errors);
		if (name == null || name.length() == 0) {
			errors.put("name", "Name is required");
		}
		if (errors != null && !errors.isEmpty()) {
			return "form";
		}
		status.setComplete();
		// request.setAttribute("name", name);
		m.addAttribute("name", name);
		return "success";
	}

	@RequestMapping(path = "/hello2.controller", method = RequestMethod.POST)
	public String processAction2(@RequestParam("name") String name, Model m, SessionStatus status) {
		// String name = request.getParameter("name");
		HashMap<String, String> errors = new HashMap<String, String>();
		// request.setAttribute("errors", errors);
		m.addAttribute("errors", errors);
		if (name == null || name.length() == 0) {
			errors.put("name", "Name is required");
		}
		if (errors != null && !errors.isEmpty()) {
			return "form";
		}
		status.setComplete();
		// request.setAttribute("name", name);
		m.addAttribute("name", name);
		return "success";
	}

}