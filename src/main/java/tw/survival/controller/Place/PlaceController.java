package tw.survival.controller.Place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tw.survival.model.Place.PlaceBean;
import tw.survival.service.Place.PlaceService;


@Controller
public class PlaceController {

	@Autowired
	private PlaceService pService;

	@PostMapping("/place/post")
	public String addPlace(@ModelAttribute PlaceBean place,Model model) {
		pService.insertPlace(place);
		PlaceBean newPlace = new PlaceBean();
		model.addAttribute("places", newPlace);
		
		return "Place/addPlace";
	}

	@GetMapping("/Place")
	public String main() {
		return "/Place/index";
	}
//	public String submit(@RequestParam("place_name") String place_name,
//			@RequestParam("place_address") String place_address,
//			@RequestParam("place_capacity") String place_capacity,
//			@RequestParam("place_fee") String place_fee,
//			@RequestParam(name = "place_photo",required = false) MultipartFile place_photo)throws IOException {		PlaceBean place = new PlaceBean(place_name,place_address,place_capacity,place_fee,place_photo.getBytes());
//		
//	}
}
