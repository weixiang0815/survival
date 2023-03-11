package tw.survival.controller.front.R.Competition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.model.Competition.CompetitionSearchCondititonsDto;
import tw.survival.service.Competition.CompetitionPictureService;
import tw.survival.service.Competition.CompetitionService;

@RestController
@RequestMapping("/front/api/competition")
public class CompetitionControllerFrontRAJAX {

	@Autowired
	private CompetitionService compService;

	@Autowired
	private CompetitionPictureService compPictureService;

	@GetMapping("/get-comp/{id}")
	public CompetitionBean getComp(@PathVariable Integer id) {
		return compService.findById(id);
	}

	@PostMapping("/multi-condition")
	public List<CompetitionBean> multiCondition(@RequestBody CompetitionSearchCondititonsDto dto) {
		return compService.multiconditionSearchFront(dto);
	}

	@GetMapping(value = "/photo/{id}", produces = "image/jpeg")
	public byte[] getCompPhoto(@PathVariable Integer id) {
		return compPictureService.findById(id).getPicture();
	}

}