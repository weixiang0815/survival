package tw.survival.controller.front.R.Competition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.model.Competition.CompetitionSearchCondititonsDto;
import tw.survival.service.Competition.CompetitionService;

@RestController
@RequestMapping("/front/api/competition")
public class CompetitionControllerFrontAJAXR {

	@Autowired
	private CompetitionService compService;

	@PostMapping("/multiCondition")
	public List<CompetitionBean> multiCondition(@RequestBody CompetitionSearchCondititonsDto dto) {
//		return compService.multiconditionSearchFront(dto);
		return compService.findAll();
	}

}