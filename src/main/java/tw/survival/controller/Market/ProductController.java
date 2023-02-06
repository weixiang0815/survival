package tw.survival.controller.Market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.survival.model.Market.ProductBean;
import tw.survival.model.Market.ProductInventory;
import tw.survival.model.Market.ProductInventoryRepository;
import tw.survival.model.Market.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductInventoryRepository productInventoryDao;

	@Autowired
	private ProductRepository productBeanDao;

	@ResponseBody
	@PostMapping("ProductRepository/add")
	public ProductInventory insertProductInventory() {
		ProductInventory pdb = new ProductInventory();
		pdb.setAmount(100);
		pdb.setPrice(5000);

		ProductInventory response = productInventoryDao.save(pdb);

		return response;
	}

	@ResponseBody
	@PostMapping("ProductRepository/addproduct")
	public ProductBean insertProduct() {
		ProductBean pdb1 = new ProductBean();
		pdb1.setName("KJM700狙擊槍");
		pdb1.setImg(new byte[100]);
		pdb1.setContext("10發裝金屬彈匣");
		pdb1.setPrice(8000);
		pdb1.setRent_fee(1200);
		pdb1.setProduct_class("狙擊槍");
		
//		pdb1.setProductClassBean(productClassDao.findById2(1));
		productBeanDao.save(pdb1);

		return pdb1;
	}

}

