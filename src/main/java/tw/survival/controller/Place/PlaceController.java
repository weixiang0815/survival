package tw.survival.controller.Place;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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

	@GetMapping("/place/all")
	public ModelAndView getAllPlace(ModelAndView mav) {
		List<PlaceBean> list = pService.getAllPlace();
		mav.setViewName("Place/showAllPlace");
		mav.getModel().put("list", list);
		return mav;
	}

	@GetMapping("/place/id")
	public ResponseEntity<byte[]> getPhotoById(@RequestParam Integer id) {
		PlaceBean place1 = pService.getOnePlaceById(id);
		byte[] placeFile = place1.getPlace_photo();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		return new ResponseEntity<byte[]>(placeFile, headers, HttpStatus.OK);
	}

	@GetMapping("/place/edit")
	public String editPlacePage(@RequestParam("id") Integer id, Model model) {
		PlaceBean p1 = pService.getOnePlaceById(id);
		model.addAttribute("place", p1);
		return "Place/editPlace";
	}

	@PostMapping("/place/edit")
	public String sendEditPlace(@RequestParam("id") Integer id, @RequestParam("place_name") String place_name,
			@RequestParam("place_address") String place_address, @RequestParam("place_photo") MultipartFile place_photo,
			@RequestParam("place_fee") Integer place_fee, @RequestParam("place_capacity") Integer place_capacity) {
		try {
			pService.updatePlaceById(id, place_name, place_address, place_photo.getBytes(), place_fee, place_capacity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/place/all";

	}

	@DeleteMapping("/place/delete")
	public String deletePlace(@RequestParam("id") Integer id) {
		pService.deletePlaceById(id);
		return "redirect:/place/all";
	}

}
