package tw.survival.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tw.survival.model.Members;

@Controller
public class MembersController {

//	@RequestMapping(value="/members", method=RequestMethod.GET)
	@GetMapping("/membersmain.controller")
	public String showForm(Model model) {
//		Members members = new Members();
		Members members = new Members("james", "male", 25);
		model.addAttribute("members", members);
		return "members";
	}

//	@RequestMapping(value="/addMembers", method=RequestMethod.POST)
	@PostMapping("addMembers")
	public String submit(@ModelAttribute("members") Members members, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "membersError";
		}
		model.addAttribute("memberName", members.getMemberName());
		model.addAttribute("gender", members.getGender());
		model.addAttribute("age", members.getAge());
		return "membersResult";
	}

}