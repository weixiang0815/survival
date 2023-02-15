package tw.survival.controller.Place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.survival.model.Place.WarehouseBean;
import tw.survival.service.Place.PlaceService;
import tw.survival.service.Place.WarehouseService;

@Controller
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;
	
	@Autowired
	private PlaceService placeService;
	
	
	@GetMapping("/warehouse/uploadPage")
	public String uploadPagePost(Model model) {
		model.addAttribute("placeList",placeService.getAllPlace() );
		model.addAttribute("warehouse", new WarehouseBean());
	    return "Place/addWarehouse";
	}
	
	
}
