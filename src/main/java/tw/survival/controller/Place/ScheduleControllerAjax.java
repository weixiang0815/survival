package tw.survival.controller.Place;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tw.survival.model.Competition.CompetitionToScheduleBean;
import tw.survival.service.Competition.CompetitionToScheduleService;
import tw.survival.service.Place.PlaceService;
import tw.survival.service.Place.ScheduleService;

@RestController
public class ScheduleControllerAjax {

	@Autowired
	private PlaceService placeService;

	@Autowired
	private CompetitionToScheduleService ctsService;

	@Autowired
	private ScheduleService scheduleService;

	@GetMapping("/schedule/cts/get/all")
	public List<CompetitionToScheduleBean> getAllCTS() {
		return ctsService.findAll();
	}

	@GetMapping("/schedule/cts/get/{id}")
	public CompetitionToScheduleBean getCTSById(@PathVariable Integer id) {
		return ctsService.findById(id);
	}

	@GetMapping("/schedule/cts/getByCompetition/{id}")
	public List<CompetitionToScheduleBean> getCTSByCompetitionId(@PathVariable Integer id) {
		return ctsService.findByCompetitionId(id);
	}

	@GetMapping("/schedule/cts/delete/{id}")
	public String deleteCTSById(@PathVariable Integer id) {
		return ctsService.deleteById(id) ? "刪除成功" : "刪除失敗";
	}

}