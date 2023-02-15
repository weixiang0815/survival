package tw.survival.controller.Place;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import tw.survival.model.Place.WarehouseBean;
import tw.survival.service.Place.PlaceService;
import tw.survival.service.Place.WarehouseService;

@Controller
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;
	
	@Autowired
	private PlaceService placeService;
	
	
	@GetMapping("/warehouse/new")
	public String newWarehouse(Model model) {
		model.addAttribute("placeList",placeService.getAllPlace() );
		model.addAttribute("warehouse", new WarehouseBean());
	    return "Place/addWarehouse";
	}
	
	@PostMapping("warehouse/create")
	public String createWarehouse(@ModelAttribute("warehouse") WarehouseBean warehouse,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("新增失敗,請重新輸入");
			return "redirect:/warehouse/new";
		}
		
		warehouse.setPlace(placeService.getOnePlaceById(warehouse.getPlaceId()));
		WarehouseBean wb = warehouseService.insertWarehouse(warehouse);
		model.addAttribute("warehouse",wb);
		return "Place/index";
	}
	
	@GetMapping("/warehouse/all")
	public ModelAndView getAllWarehouse(ModelAndView mav) {
		List<WarehouseBean> list = warehouseService.getAllWarehouse();
		mav.setViewName("Place/showAllWarehouse");
		mav.getModel().put("list", list);
		return mav;
	}
	
	@PostMapping("/warehouse/edit")
	public String editWarehouse() {
		return "";
	}
	
}
