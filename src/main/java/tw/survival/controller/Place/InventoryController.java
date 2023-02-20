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

import tw.survival.model.Place.InventoryBean;
import tw.survival.service.Market.ProductService;
import tw.survival.service.Place.InventoryService;
import tw.survival.service.Place.WarehouseService;

@Controller
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private WarehouseService warehouseService;

	@GetMapping("/inventory/new")
	public String newInventory(Model model) {
		model.addAttribute("inventory", new InventoryBean());
		model.addAttribute("productList", productService.findAllProduct());
		model.addAttribute("warehouseList", warehouseService.getAllWarehouse());
		return "Place/addInventory";

	}

	@PostMapping("inventory/create")
	public String createInventory(@ModelAttribute("inventory") InventoryBean inventory, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("新增失敗,請重新輸入");
			return "redirect:/inventory/new";
		}

		inventory.setWarehouse(warehouseService.getOneWarehouseById(inventory.getWarehouseId()));
		inventory.setProduct(productService.getProductById(inventory.getProductId()));
		InventoryBean ib = inventoryService.insertInventory(inventory);
		model.addAttribute("inventory", ib);
		return "redirect:/inventory/all";
	}

	@GetMapping("/inventory/all")
	public ModelAndView getAllInventory(ModelAndView mav) {
		List<InventoryBean> list = inventoryService.getAllInventory();
		mav.setViewName("Place/showAllInventory");
		mav.getModel().put("list", list);
		return mav;
	}
}
