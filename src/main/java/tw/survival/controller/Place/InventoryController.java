package tw.survival.controller.Place;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tw.survival.model.Market.ProductBean;
import tw.survival.model.Place.InventoryBean;
import tw.survival.model.Place.WarehouseBean;
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
		return "back/Place/addInventory";

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
		mav.setViewName("back/Place/showAllInventory");
		mav.getModel().put("list", list);
		return mav;
	}

	@GetMapping("/inventory/edit")
	public String editInventory(@RequestParam("id") Integer id, Model model) {
		InventoryBean inventory = inventoryService.getInventoryById(id);
		WarehouseBean warehouse = inventory.getWarehouse();
		ProductBean product = inventory.getProduct();
		model.addAttribute("warehouse", warehouse);
		model.addAttribute("product", product);
		model.addAttribute("inventory", inventory);
		return "back/Place/editInventory";
	}

	@PutMapping("/inventory/edit")
	public String sendEditInventory(@ModelAttribute("inventory") InventoryBean inventory) {
		inventoryService.updateInventory(inventory);
		return "redirect:/inventory/all";
	}

	@PostMapping("/inventory/delete")
	public String deleteInventory(@RequestParam("id") Integer id) {
		inventoryService.deleteInventoryById(id);
		return "redirect:/inventory/all";
	}

}