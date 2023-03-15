package tw.survival.controller.front.CUD.Competition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.survival.model.Competition.SignUpBean;
import tw.survival.service.Competition.SignUpService;

@RestController
@RequestMapping("/front/api/competition")
@SessionAttributes({ "employee", "player" })
public class CompetitionControllerFrontCUDAJAX {

	@Autowired
	private SignUpService signupService;

	@GetMapping("/signup/check/{playerId}/{compId}")
	public boolean checkSignedUp(@PathVariable("playerId") Integer playerId, @PathVariable("compId") Integer compId) {
		SignUpBean signup = signupService.findByPlayerIdAndCompId(playerId, compId);
		return signup != null;
	}

	@GetMapping("signup/{id}")
	public SignUpBean findById(@PathVariable("id") Integer id) {
		return signupService.findById(id);
	}

	@GetMapping("signup/all")
	public List<SignUpBean> findAll() {
		return signupService.findAll();
	}

}