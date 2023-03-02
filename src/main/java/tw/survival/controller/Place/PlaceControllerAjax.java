package tw.survival.controller.Place;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tw.survival.model.Place.PlaceBean;
import tw.survival.service.Place.PlaceService;
import tw.survival.service.Place.WarehouseService;

@RestController
public class PlaceControllerAjax {

	@Autowired
	private PlaceService placeService;

	@Autowired
	private WarehouseService warehouseService;

	@PostMapping("/place/api/create")
	public ResponseEntity<String> createPlace(@RequestParam("place_name") String placeName,
			@RequestParam("place_address") String placeAddress, @RequestParam("place_capacity") Integer placeCapacity,
			@RequestParam("place_fee") Integer placeFee, @RequestParam("place_photo") MultipartFile file) {

		try {
			PlaceBean pb = new PlaceBean();
			pb.setPlace_name(placeName);
			pb.setPlace_address(placeAddress);
			pb.setPlace_capacity(placeCapacity);
			pb.setPlace_fee(placeFee);
			pb.setPlace_photo(file.getBytes());

			placeService.insertPlace(pb);

			return ResponseEntity.ok("上傳成功");
		} catch (IOException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body("失敗");
		}
	}

	@GetMapping("/place/api/{id}")
	public PlaceBean getPlaceById(@PathVariable Integer id) {
		return placeService.getOnePlaceById(id);
	}

	@GetMapping("/place/api/all")
	public List<PlaceBean> getAllPlace() {
		return placeService.getAllPlace();
	}

	@PostMapping("/place/api/edit")
	public String sendEditPlace(@RequestParam("id") Integer id, @RequestParam("place_name") String place_name,
			@RequestParam("place_address") String place_address, @RequestParam("place_photo") MultipartFile place_photo,
			@RequestParam("place_fee") Integer place_fee, @RequestParam("place_capacity") Integer place_capacity) {
		try {
			placeService.updatePlaceById(id, place_name, place_address, place_photo.getBytes(), place_fee,
					place_capacity);
			return "更新成功";
		} catch (Exception e) {
			return "更新失敗：" + e.getMessage();
		}
	}

	@DeleteMapping("/place/api/delete")
	public String deletePlace(@RequestParam("id") Integer id) {
		try {
			placeService.deletePlaceById(id);
			return "刪除成功";
		} catch (Exception e) {
			return "刪除失敗:" + e.getMessage();
		}
	}

}