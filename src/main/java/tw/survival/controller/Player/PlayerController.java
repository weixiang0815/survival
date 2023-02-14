package tw.survival.controller.Player;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.survival.model.Player.PlayerBean;
import tw.survival.model.Player.PlayerRepository;
import tw.survival.service.Player.PlayerService;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService pService;

	@GetMapping("/player.main")
	public String main() {
		return "Player/index";
	}

//	C
	@GetMapping("/player/add")
	public String addPlayer() {
		return "Player/user";
	}

	// R
	@GetMapping("/player/list")
	public String list(Model m) {
		List<PlayerBean> list = pService.findAll();
		m.addAttribute("player", list);
		return "Player/SelectAllResult";
	}

	@GetMapping("/player/update")
	public String updatePlayer(@RequestParam("id") Integer id, Model model) {
		PlayerBean player = pService.findByBean(id);
		model.addAttribute("player", player);
		return "Player/UpdateUser1";
	}

	@ResponseBody
	@PostMapping("/player/addpost")
	public String postPlayer(@RequestParam("id") Integer id, @RequestParam("name") String name,
			@RequestParam("account") String account, @RequestParam("password") String password,
			@RequestParam("identity") String identity_number, @RequestParam("email") String email,
			@RequestParam("age") Integer age, @RequestParam("region") String region,
			@RequestParam("nickname") String nickname, @RequestParam("address") String address,
			@RequestParam("thumbnail") MultipartFile thumbnail, @RequestParam("sex") String sex,
			@RequestParam("birthday") Date birthday, @RequestParam("info") Date info,
			@RequestParam("phone") String phone, @RequestParam("banned") String banned, Model model) {
		try {
			PlayerBean player = new PlayerBean();
			player.setId(id);
			player.setName(name);
			player.setAccount(account);
			player.setPassword(password);
			player.setIdentity_number(identity_number);
			player.setEmail(email);
			player.setAge(age);
			player.setNickname(nickname);
			player.setRegion(region);
			player.setAddress(address);
//			player.setThumbnail();
			player.setInfo(banned);
			player.setSex(sex);
			player.setBirthday(birthday);
			player.setPhone(phone);
			player.setBanned("T");
			pService.addplayer(player);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "Player/user";
	}

	@PutMapping("/player/update")
	public String updateById(@ModelAttribute("player") PlayerBean player, Model model) {
		pService.addplayer(player);
		return "redirect:/player/list";

	}
}
