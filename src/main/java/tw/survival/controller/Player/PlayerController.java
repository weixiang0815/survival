package tw.survival.controller.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tw.survival.service.Player.PlayerService;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService uService;

	@GetMapping("/user")
	public String main() {
		return "Player/index";
	}

	@GetMapping("/player/add")
	public String addPlayer() {
		return "Player/user";
	}
}