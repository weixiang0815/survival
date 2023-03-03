package tw.survival.controller.Place;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.survival.model.Competition.CompetitionBean;
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

	@ResponseBody
	@GetMapping("/schedule/all")
	public List<ScheduleDTO> getAllSchedule(){
		List<CompetitionBean> publishedComps = competitionService.findByStatus("已發布");
		List<CompetitionBean> endedComps = competitionService.findByStatus("已結束");
		List<CompetitionBean> unpublishedComps = competitionService.findByStatus("未發布");
		
		String startStr[] = {"06:00:00","12:00:00","18:00:00","00:00:00"};
		String endStr[] = {"12:00:00","18:00:00","00:00:00","06:00:00"};
		List<ScheduleDTO> list = new ArrayList<>();
		
		
		for(CompetitionBean comp : publishedComps) {
			String title = comp.getMandarinName();
			String start = comp.getStartDate() +"T"+ startStr[comp.getStartTimespan()-1];
			String end = comp.getEndDate() +"T"+ endStr[comp.getEndTimespan()-1];
			String type = comp.getStatus();
			String color = "grey";
			ScheduleDTO Sdto = new ScheduleDTO(title,start,end,type,color);
			list.add(Sdto);
		
		}
		
		for(CompetitionBean comp : endedComps) {
			String title = comp.getMandarinName();
			String start = comp.getStartDate() +"T"+ startStr[comp.getStartTimespan()-1];
			String end = comp.getEndDate() +"T"+ endStr[comp.getEndTimespan()-1];
			String type = comp.getStatus();
			String color = "blue";
			ScheduleDTO Sdto = new ScheduleDTO(title,start,end,type,color);
			list.add(Sdto);
		
		}
		
		for(CompetitionBean comp : unpublishedComps) {
			String title = comp.getMandarinName();
			String start = comp.getStartDate() +"T"+ startStr[comp.getStartTimespan()-1];
			String end = comp.getEndDate() +"T"+ endStr[comp.getEndTimespan()-1];
			String type = comp.getStatus();
			String color = "red";
			ScheduleDTO Sdto = new ScheduleDTO(title,start,end,type,color);
			list.add(Sdto);
		
		}
		
		return list;
	}
	
	
}