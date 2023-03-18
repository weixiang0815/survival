package tw.survival.controller.front.R.Place;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class PlaceControllerFront {

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private PlaceService placeService;

	@Autowired
	private CompetitionToScheduleService CTSService;

	@Autowired
	private CompetitionService competitionService;

	@GetMapping("/front/place/index")
	public String goIndex() {
		return "front/Place/index";
	}

	@GetMapping("/front/place/detail")
	public String goPlaceDetail(@RequestParam("id") Integer id,Model model) {
		model.addAttribute("placeDetail", placeService.getOnePlaceById(id));
		return "front/Place/detail";
	}

	@GetMapping("/front/place/all")
	public String getAllPlace(Model model) {
		List<PlaceBean> list = placeService.getAllPlace();
		model.addAttribute("placelist", list);

		return "front/Place/allPlace";
	}

	@GetMapping("/front/place/id")
	public ResponseEntity<byte[]> getPhotoById(@RequestParam Integer id) {
		PlaceBean place2 = placeService.getOnePlaceById(id);
		byte[] placeFile2 = place2.getPlace_photo();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		return new ResponseEntity<byte[]>(placeFile2, headers, HttpStatus.OK);
	}

	@GetMapping("front/schedule/new")
	public String newSchedule(Model model) {
		model.addAttribute("schedule", new ScheduleBean());
		model.addAttribute("placeList", placeService.getAllPlace());
		model.addAttribute("ctsList", CTSService.findAll());
		return "front/Place/schedule";
	}

	@PostMapping("/front/schedule/create")
	public String createSchedule(@ModelAttribute("schedule") ScheduleBean schedule, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("失敗");
			return "redirect:/front/schedule/new";
		}
		schedule.setPlace(placeService.getOnePlaceById(schedule.getPlaceId()));
		ScheduleBean sb = scheduleService.insertSchedule(schedule);
		model.addAttribute("schedule", sb);
		return "redirect:/front/schedule/new";
	}

	@ResponseBody
	@GetMapping("/front/schedule/all")
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
			String id = comp.getId().toString();
			ScheduleDTO Sdto = new ScheduleDTO(title, start, end, type, color);
			Sdto.setUrl("http://localhost:8080/Survival/front/competition/detail/"+id);
			list.add(Sdto);
		}

		for (CompetitionBean comp : endedComps) {
			String placeId = comp.getPlace().getId().toString();
			String title = comp.getMandarinName() + "-" + comp.getPlace().getPlace_name();
			String start = comp.getStartDate() + "T" + startStr[comp.getStartTimespan() - 1];
			String end = comp.getEndDate() + "T" + endStr[comp.getEndTimespan() - 1];
			String type = comp.getStatus();
			String color = "blue";
			String id = comp.getId().toString();
			ScheduleDTO Sdto = new ScheduleDTO(title, start, end, type, color);
			Sdto.setUrl("http://localhost:8080/Survival/front/competition/detail/"+id);
			list.add(Sdto);
		}

		for (CompetitionBean comp : unpublishedComps) {
			String placeId = comp.getPlace().getId().toString();
			String title = comp.getMandarinName() + "-" + comp.getPlace().getPlace_name();
			String start = comp.getStartDate() + "T" + startStr[comp.getStartTimespan() - 1];
			String end = comp.getEndDate() + "T" + endStr[comp.getEndTimespan() - 1];
			String type = comp.getStatus();
			String color = "brown";
			String id = comp.getId().toString();
			ScheduleDTO Sdto = new ScheduleDTO(title, start, end, type, color);
			Sdto.setUrl("http://localhost:8080/Survival/front/competition/detail/"+id);
			list.add(Sdto);
		}

		return list;
	}

	@ResponseBody
	@GetMapping("/front/schedule/select/{placeId}")
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
			String id = comp.getId().toString();
			String color;
			if (type.contentEquals("已發布")) {
				color = "green";
			} else if (type.contentEquals("未發布")) {
				color = "pink";
			} else if (type.contentEquals("已結束")) {
				color = "blue";
			} else {
				color = "yellow";
			}
			ScheduleDTO Sdto = new ScheduleDTO(title, start, end, type, color);
			Sdto.setUrl("http://localhost:8080/Survival/front/competition/detail/"+id);
			Sdto.setPlaceId(placeId.toString());
			list.add(Sdto);
		}
		return list;
	}

}