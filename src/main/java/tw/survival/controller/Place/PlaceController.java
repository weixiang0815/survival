package tw.survival.controller.Place;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.survival.model.Place.PlaceBean;
import tw.survival.model.Place.PlaceService;

@Controller
public class PlaceController {

	@Autowired
	private PlaceService pService;

	@GetMapping("/placemain.controller")
	public String showForm(Model model) {
		return "Place/place";
	}

//	public String submit(@RequestParam("place_name") String place_name,
//			@RequestParam("place_address") String place_address,
//			@RequestParam("place_capacity") String place_capacity,
//			@RequestParam("place_fee") String place_fee,
//			@RequestParam(name = "place_photo",required = false) MultipartFile place_photo)throws IOException {		PlaceBean place = new PlaceBean(place_name,place_address,place_capacity,place_fee,place_photo.getBytes());
//		
//	}
}
