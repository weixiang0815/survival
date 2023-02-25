package tw.survival.controller.Player;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tw.survival.model.Player.PlayerBean;
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

//U

	@GetMapping("/player/update")
	public String updatePlayer(@RequestParam("id") Integer id, Model model) {
		PlayerBean player = pService.findByBean(id);
		model.addAttribute("player", player);
		return "Player/UpdateUser1";
	}

	@PutMapping("/player/update1")
	public String updateById(@ModelAttribute PlayerBean player) {
		pService.update(player);
		return "redirect:/player/list";
	}

	// D
	@DeleteMapping("/player/delete")
	public String deletePlayer(@PathVariable("id") Integer id, RedirectAttributes ra) {
		try {
			ra.addFlashAttribute("DeleteMessage", "刪除成功: 編號=" + id);
			pService.delete(id);

		} catch (Exception error) {

		}

		return "redirect:/player/list";
	}

	@PostMapping("/player/addpost")
	public String postPlayer(@RequestParam("name") String name, @RequestParam("account") String account,
			@RequestParam("password") String password, @RequestParam("identity") String identity_number,
			@RequestParam("email") String email, @RequestParam("age") Integer age,
			@RequestParam("county") String county, @RequestParam("district") String district,
			@RequestParam("nickname") String nickname, @RequestParam("address") String address,
			@RequestParam("thumbnail") MultipartFile thumbnail, @RequestParam("sex") String sex,
			@RequestParam("birthday") Date birthday, @RequestParam("info") String info,
			@RequestParam("phone") String phone, @RequestParam("banned") String banned, Model model) {

		try {
			PlayerBean player = new PlayerBean();
			player.setName(name);
			player.setAccount(account);
			player.setPassword(password);
			player.setIdentity_number(identity_number);
			player.setEmail(email);
			player.setAge(age);
			player.setNickname(nickname);
			player.setCounty(county);
			player.setDistrict(district);
			player.setAddress(address);
			player.setThumbnail(thumbnail.getBytes());
			player.setInfo(banned);
			player.setSex(sex);
			player.setBirthday(birthday);
			player.setPhone(phone);
			player.setInfo("null");
			player.setBanned("T");
			pService.addplayer(player);
			System.out.print("註冊成功");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "redirect:/player/list";
	}

	// GetPhoto
	@GetMapping("/player/photo")
	public ResponseEntity<byte[]> getPhotobyId(@RequestParam Integer id) {
		PlayerBean player = pService.findByBean(id);
		byte[] photofile = player.getThumbnail();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(photofile, headers, HttpStatus.OK);
	}

}
