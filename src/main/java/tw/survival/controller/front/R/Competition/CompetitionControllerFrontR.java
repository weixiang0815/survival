package tw.survival.controller.front.R.Competition;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.model.Competition.CompetitionPictureBean;
import tw.survival.model.Competition.CompetitionPictureDto;
import tw.survival.model.Place.PlaceBean;
import tw.survival.service.Competition.CompetitionService;
import tw.survival.service.Place.PlaceService;

@Controller
@RequestMapping("/front")
@SessionAttributes({ "player", "employee" })
public class CompetitionControllerFrontR {

	@Autowired
	private CompetitionService compService;

	@Autowired
	private PlaceService placeService;

	@GetMapping("/competition")
	public String goIndex() {
		return "front/Competition/index";
	}

	@GetMapping("/competition/detail/{id}")
	public String goCompDetail(@PathVariable Integer id, Model model) {
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
		PlaceBean place = comp.getPlace();
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日");
		model.addAttribute("place", place);
		try {
			model.addAttribute("startDate", outputFormat.format(inputFormat.parse(comp.getStartDate())));
			model.addAttribute("endDate", outputFormat.format(inputFormat.parse(comp.getEndDate())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		model.addAttribute("startTime", start);
		model.addAttribute("endTime", end);
		model.addAttribute("comp", comp);
		model.addAttribute("prizes", comp.getCompetitionPrizes());
		model.addAttribute("pictures", comp.getPictures());
		return "front/Competition/compDetail";
	}

	@GetMapping("/competition/photo")
	public String goCompPhoto(Model model) {
		List<CompetitionBean> comps = compService.findAll();
		List<CompetitionPictureDto> pictures = new ArrayList<>();
		comps.forEach(comp -> {
			Set<CompetitionPictureBean> pic = comp.getPictures();
			if (pic != null && pic.size() != 0) {
				CompetitionPictureDto dto = new CompetitionPictureDto();
				dto.setCompId(comp.getId());
				dto.setCompName(comp.getMandarinName());
				dto.setPicSet(pic);
				pictures.add(dto);
			}
		});
		List<PlaceBean> places = placeService.getAllPlace();
		model.addAttribute("pictures", pictures);
		model.addAttribute("places", places);
		return "front/Competition/photo";
	}

	@GetMapping("/competition/history")
	public String goCompHistory() {
		return "front/Competition/history";
	}

	@GetMapping("/competition/show")
	public String goShow(Model model) {
		List<CompetitionBean> comps = compService.findAll();
		List<PlaceBean> places = placeService.getAllPlace();
		model.addAttribute("comps", comps);
		model.addAttribute("places", places);
		return "front/Competition/showCompetitions";
	}

}