package tw.survival.controller.Place;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import tw.survival.model.Place.PlaceBean;
import tw.survival.service.Place.PlaceService;

@Controller
public class PlaceController {

	@Autowired
	private PlaceService pService;

	@GetMapping("/place")
	public String gotoIndex() {
		return "Place/index";
	}

	@GetMapping("/place/uploadPage")
	public String uploadPage() {
		return "Place/addPlace";
	}

	@ResponseBody
	@PostMapping("/place/post")
	public String uploadPagePost(@RequestParam("place_name") String placeName,
			@RequestParam("place_address") String placeAdress, @RequestParam("place_capacity") Integer placeCapacity,
			@RequestParam("place_fee") Integer placeFee, @RequestParam("place_photo") MultipartFile file) {

		try {
			PlaceBean pb = new PlaceBean();
			pb.setPlace_name(placeName);
			pb.setPlace_address(placeAdress);
			pb.setPlace_capacity(placeCapacity);
			pb.setPlace_fee(placeFee);
			pb.setPlace_photo(file.getBytes());

			pService.insertPlace(pb);
			return "上傳成功";
		} catch (IOException e) {
			e.printStackTrace();
			
			return "失敗";
		}
	}

}
