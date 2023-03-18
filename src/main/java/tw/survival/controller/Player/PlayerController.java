package tw.survival.controller.Player;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tw.survival.model.Player.PlayerBean;
import tw.survival.service.Market.CartService;
import tw.survival.service.Player.PlayerService;
import tw.survival.service.email.EmailService;
import tw.survival.validators.AddPlayerValidator;

@Controller
public class PlayerController {
	@Autowired
	public AddPlayerValidator validator;

	String Ladypreset = "/images/lady.jpg";
	String Manpreset = "/images/man.jpg";
	@Autowired
	ServletContext context;
	@Autowired
	private PlayerService pService;
	@Autowired
	private CartService cartService;

	@Autowired
	private EmailService emailService;

	@GetMapping("/player.main")
	public String main() {
		return "front/Player/disclaimer";
	}

//	@ResponseBody
//	@GetMapping("/player/cartlist/{id}")
//	public String cartPlayer(@PathVariable("id") Integer id,Model model) {
//		List<CartBean>list=cartService.listCartItems(id.);
//		model.addAttribute("player",list);
//		return"";
//	}

//	C
	@GetMapping("/player/add")
	public String addPlayer(Model m) {
		m.addAttribute("player", new PlayerBean());
		return "front/Player/user";
	}

	// R
	@GetMapping("/player/list")
	public String list(Model m) {
		List<PlayerBean> list = pService.findAll();
		m.addAttribute("player", list);
		return "back/Player/SelectAllResult";
	}

	@ResponseBody
	@GetMapping("/player/get/{id}")
	public PlayerBean getPlayerById(@PathVariable Integer id) {
		return pService.findByBean(id);
	}

	// onlyR
	@GetMapping("/player/{id}")
	public String OnlygetPlayerById(@PathVariable Integer id, Model m) {
		PlayerBean player = pService.findByBean(id);
		m.addAttribute("player", player);
		return "front/Player/SelectOnlyPlayer";
	}

	// FU
	@GetMapping("/player/frontupdate")
	public String frontupdatePlayer(@RequestParam("id") Integer id, Model model) {
		PlayerBean player = pService.findByBean(id);
		model.addAttribute("player", player);
		return "front/Player/UpdateUser";
	}

	@PostMapping("/player/update2")
	public String frontupdateById(@ModelAttribute PlayerBean player) {
		String sex = player.getSex();
		MultipartFile playerImage = player.getPlayerImage();
		if (sex == null) {

		}
		if (playerImage != null && !playerImage.isEmpty()) {
			try {
				byte[] img = playerImage.getBytes();
				Blob blob = new SerialBlob(img);
				player.setThumbnail(blob);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		pService.update(player);
		return "front/Player/SelectOnlyPlayer";
	}

//bU
	@GetMapping("/player/update")
	public String updatePlayer(@RequestParam("id") Integer id, Model model) {
		PlayerBean player = pService.findByBean(id);
		model.addAttribute("player", player);
		return "back/Player/UpdateUser1";
	}

	@PutMapping("/player/update1")
	public String updateById(@ModelAttribute PlayerBean player) {
		String sex = player.getSex();
		MultipartFile playerImage = player.getPlayerImage();
		if (sex == null) {

		}
		if (playerImage != null && !playerImage.isEmpty()) {
			try {
				byte[] img = playerImage.getBytes();
				Blob blob = new SerialBlob(img);
				player.setThumbnail(blob);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		pService.update(player);
		return "redirect:/player/list";
	}

	// D
	@DeleteMapping("/player/delete")
	public String deletePlayer(@RequestParam("id") Integer id, RedirectAttributes ra) {
		try {

			ra.addFlashAttribute("DeleteMessage", "刪除成功: 編號=" + id);
			pService.delete(id);

		} catch (Exception error) {

		}

		return "redirect:/player/list";
	}

	@PostMapping("/player/addpost")
	public String postPlayer(@Valid @ModelAttribute("player") PlayerBean player, Model model, HttpSession session,
			BindingResult bindingResult) {
		validator.validate(player, bindingResult);
		if (bindingResult.hasErrors()) {
			List<ObjectError> list = bindingResult.getAllErrors();
			model.addAttribute("error", list);
			for (ObjectError error : list) {
				System.out.println("有錯誤：" + error);
			}
			System.out.println("======================");
			return "front/Player/user";
		}
		MultipartFile playerImage = player.getPlayerImage();
		if (playerImage != null && !playerImage.isEmpty()) {
			try {
				byte[] img = playerImage.getBytes();
				Blob blob = new SerialBlob(img);
				player.setThumbnail(blob);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		player.setStatus(0);
		player.setCode(UUID.randomUUID().toString());
//		session.setAttribute("player", player);
		PlayerBean player2 = pService.addplayer(player);
		emailService.sendHtmlMail(player2);

		System.out.println("註冊成功");
		return "redirect:/Player/login";
	}

	// GetPhoto
	@ResponseBody
	@GetMapping("/player/photo/{id}")
	public ResponseEntity<byte[]> getPhotobyId(@PathVariable Integer id) {
		PlayerBean player = pService.findByBean(id);
		byte[] photofile = null;
		ResponseEntity<byte[]> re = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		Blob blob = player.getThumbnail();

		if (blob != null) {
			photofile = blobToByteArray(blob);
		} else {
			String path = null;
			if (player.getSex().equals("F")) {
				path = Ladypreset;
			} else if (player.getSex().equals("M")) {
				path = Manpreset;
			}
			photofile = fileToByteArray(path);
		}

		re = new ResponseEntity<byte[]>(photofile, headers, HttpStatus.OK);
		return re;
	}

	private byte[] fileToByteArray(String path) {
		byte[] result = null;
		try (InputStream is = context.getResourceAsStream(path);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public byte[] blobToByteArray(Blob blob) {
		byte[] result = null;
		try (InputStream is = blob.getBinaryStream(); ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// searchName
	@PostMapping("/player/namelike")
	public String findPlayerName0(@RequestParam("name") String name, Model m) {
		List<PlayerBean> player = pService.findName(name);
		m.addAttribute("player", player);
		return "back/Player/SelectAllResult";

	}

	@GetMapping("/active/{id}")
	public String toemail(@PathVariable("id") Integer id) {
		pService.UpdateStatus(id, 1);
		return "redirect:front/Player/login";
	}	
}