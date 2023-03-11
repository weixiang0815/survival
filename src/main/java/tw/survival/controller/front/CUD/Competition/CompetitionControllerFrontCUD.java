package tw.survival.controller.front.CUD.Competition;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.model.Competition.SignUpBean;
import tw.survival.service.Competition.CompetitionService;

@Controller
@RequestMapping("/front")
@SessionAttributes({ "player", "employee" })
public class CompetitionControllerFrontCUD {

	@Autowired
	private CompetitionService compService;

	@GetMapping("/signup")
	public String goSignUp(@RequestParam(value = "id", required = false) Integer id, Model model) {
		List<CompetitionBean> comps = compService.findAll();
		if (id != null) {
			CompetitionBean comp = compService.findById(id);
			int startTimespan = comp.getStartTimespan();
			String start = "";
			int endTimespan = comp.getEndTimespan();
			String end = "";
			switch (startTimespan) {
			case 1:
				start = "早上（6:00～12:00）";
				break;
			case 2:
				start = "下午（12:00～18:00）";
				break;
			case 3:
				start = "晚上（18:00～00:00）";
				break;
			case 4:
				start = "半夜（00:00～6:00）";
				break;
			}
			switch (endTimespan) {
			case 1:
				end = "早上（6:00～12:00）";
				break;
			case 2:
				end = "下午（12:00～18:00）";
				break;
			case 3:
				end = "晚上（18:00～00:00）";
				break;
			case 4:
				end = "半夜（00:00～6:00）";
				break;
			}
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日");
			try {
				model.addAttribute("startDate", outputFormat.format(inputFormat.parse(comp.getStartDate())));
				model.addAttribute("endDate", outputFormat.format(inputFormat.parse(comp.getEndDate())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			model.addAttribute("startTime", start);
			model.addAttribute("endTime", end);
			model.addAttribute("competition", comp);
		}
		model.addAttribute("compList", comps);
		model.addAttribute("signup", new SignUpBean());
		return "front/Competition/signup";
	}

}