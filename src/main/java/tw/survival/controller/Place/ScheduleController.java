package tw.survival.controller.Place;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.model.Place.PlaceBean;
import tw.survival.model.Place.ScheduleBean;
import tw.survival.model.Place.ScheduleDTO;
import tw.survival.service.Competition.CompetitionService;
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

	@Autowired
	private CompetitionService competitionService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@GetMapping("/schedule/new")
	public String newSchedule(Model model) {
		model.addAttribute("schedule", new ScheduleBean());
		model.addAttribute("placeList", placeService.getAllPlace());
		model.addAttribute("ctsList", CTSService.findAll());
		return "back/Place/addSchedule";
	}

	@PostMapping("/schedule/create")
	public String createSchedule(@ModelAttribute("schedule") ScheduleBean schedule, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("失敗");
			return "redirect:/schedule/new";
		}
		schedule.setPlace(placeService.getOnePlaceById(schedule.getPlaceId()));
		ScheduleBean sb = scheduleService.insertSchedule(schedule);
		model.addAttribute("schedule", sb);
		return "redirect:/schedule/new";
	}

	@ResponseBody
	@GetMapping("/schedule/all")
	public List<ScheduleDTO> getAllSchedule() {
		List<CompetitionBean> publishedComps = competitionService.findByStatus("已發布");
		List<CompetitionBean> endedComps = competitionService.findByStatus("已結束");
		List<CompetitionBean> unpublishedComps = competitionService.findByStatus("未發布");

		String startStr[] = { "06:00:00", "12:00:00", "18:00:00", "00:00:00" };
		String endStr[] = { "12:00:00", "18:00:00", "00:00:00", "06:00:00" };
		List<ScheduleDTO> list = new ArrayList<>();

		for (CompetitionBean comp : publishedComps) {
			String placeId = comp.getPlace().getId().toString();
			String title = comp.getMandarinName() + "-" + comp.getPlace().getPlace_name();
			String start = comp.getStartDate() + "T" + startStr[comp.getStartTimespan() - 1];
			String end = comp.getEndDate() + "T" + endStr[comp.getEndTimespan() - 1];
			String type = comp.getStatus();
			String color = "green";
			ScheduleDTO Sdto = new ScheduleDTO(title, start, end, type, color);
			list.add(Sdto);
		}

		for (CompetitionBean comp : endedComps) {
			String placeId = comp.getPlace().getId().toString();
			String title = comp.getMandarinName() + "-" + comp.getPlace().getPlace_name();
			String start = comp.getStartDate() + "T" + startStr[comp.getStartTimespan() - 1];
			String end = comp.getEndDate() + "T" + endStr[comp.getEndTimespan() - 1];
			String type = comp.getStatus();
			String color = "blue";
			ScheduleDTO Sdto = new ScheduleDTO(title, start, end, type, color);
			list.add(Sdto);
		}

		for (CompetitionBean comp : unpublishedComps) {
			String placeId = comp.getPlace().getId().toString();
			String title = comp.getMandarinName() + "-" + comp.getPlace().getPlace_name();
			String start = comp.getStartDate() + "T" + startStr[comp.getStartTimespan() - 1];
			String end = comp.getEndDate() + "T" + endStr[comp.getEndTimespan() - 1];
			String type = comp.getStatus();
			String color = "red";
			ScheduleDTO Sdto = new ScheduleDTO(title, start, end, type, color);
			list.add(Sdto);
		}

		return list;
	}
	
	@ResponseBody
	@GetMapping("/schedule/select/{placeId}")
	public List<ScheduleDTO> findCompByPlaceId(@PathVariable Integer placeId) {
		List<CompetitionBean> compList = competitionService.findByPlaceId(placeId);
		String startStr[] = { "06:00:00", "12:00:00", "18:00:00", "00:00:00" };
		String endStr[] = { "12:00:00", "18:00:00", "00:00:00", "06:00:00" };
		List<ScheduleDTO> list = new ArrayList<>();
		for (CompetitionBean comp : compList) {
			String title = comp.getMandarinName() + "-" + comp.getStatus();
			String start = comp.getStartDate() + "T" + startStr[comp.getStartTimespan() - 1];
			String end = comp.getEndDate() + "T" + endStr[comp.getEndTimespan() - 1];
			String type = comp.getStatus();
			System.out.println(type);
			String color ;
			if(type.contentEquals("已發布")) {
				color = "green";
			}else if(type.contentEquals("未發布")) {
				color = "red";
			}else if(type.contentEquals("已結束")) {
				color = "blue";
			}else {
				color = "grey";
			}
			ScheduleDTO Sdto = new ScheduleDTO(title, start, end, type, color);
			Sdto.setPlaceId(placeId.toString());
			list.add(Sdto);
		}
		return list;
	}

}