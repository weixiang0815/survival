package tw.survival.controller.Place;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tw.survival.model.Place.PlaceBean;
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
		return "redirect:/warehouse/all";
	}
	
	@GetMapping("/warehouse/all")
	public ModelAndView getAllWarehouse(ModelAndView mav) {
		List<WarehouseBean> list = warehouseService.getAllWarehouse();
		mav.setViewName("Place/showAllWarehouse");
		mav.getModel().put("list", list);
		return mav;
	}
	
	@GetMapping("/warehouse/edit")
	public String editWarehouse(@RequestParam("id") Integer id, Model model) {
		WarehouseBean warehouse = warehouseService.getOneWarehouseById(id);
		PlaceBean place = warehouse.getPlace();
		model.addAttribute("place", place);
		model.addAttribute("warehouse", warehouse);
		return "Place/editWarehouse";
	}
	
	@PutMapping("/warehouse/edit")
	public String sendEditWarehouse(@ModelAttribute("warehouse") WarehouseBean warehouse) {
		warehouseService.updateWarehouse(warehouse);
		return "redirect:/warehouse/all";
	}
	
	@PostMapping("/warehouse/delete")
	public String deleteWarehouse(@RequestParam("id") Integer id) {
		warehouseService.deleteWarehouseById(id);
		return "redirect:/warehouse/all";
	}
	
	
	
}
