package tw.survival.controller.Market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.survival.model.Market.ProductBean;
import tw.survival.model.Market.ProductClassBean;
import tw.survival.model.Market.ProductInventory;
import tw.survival.model.Market.ProductInventoryRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductInventoryRepository ProductInventoryDao;
	
	@Autowired
	private ProductBean ProductBeanDao;
	
	@ResponseBody
	@PostMapping("ProductRepository/add")
	public ProductInventory insertProductInventory() {
		ProductInventory pdb = new ProductInventory();
		pdb.setAmount(100);
		pdb.setPrice(5000);
		
		ProductInventory response =ProductInventoryDao.save(pdb);
		
		return response;
	}
	
	@ResponseBody
	@PostMapping("ProductRepository/addproduct")
	public ProductBean insertProduct() {
		ProductBean pdb1 = new ProductBean();
		pdb1.setName("100");
		pdb1.setContext("100");
		pdb1.setLocal("100");
		pdb1.setFk_product_class_id(null);
		
		ProductClassBean pdb2 = new ProductClassBean();
		
		
		ProductBean response1 =ProductBeanDao;
		
		return response1;
	}
	
	
	
}
