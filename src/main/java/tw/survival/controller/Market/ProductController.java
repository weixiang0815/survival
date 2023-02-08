package tw.survival.controller.Market;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.survival.model.Market.ProductBean;
import tw.survival.model.Market.ProductInventory;
import tw.survival.model.Market.ProductInventoryRepository;
import tw.survival.model.Market.ProductRepository;
import tw.survival.service.Market.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductInventoryRepository productInventoryDao;

	@Autowired
	private ProductRepository productBeanDao;

	@Autowired
	private ProductService pService;

	@GetMapping("/Market/add_Product")
	private String uploadPage() {
		return "Market/add_Product";
	}

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
	@PostMapping("ProductRepository/addproduct_text")
	public ProductBean insertProduct1() {
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

	@ResponseBody
	@PostMapping("ProductRepository/addproduct")
	public String insertProduct(@RequestParam("photoName") String fileName,
			@RequestParam("photoContext") String Context, 
			@RequestParam("Product_class") String Product_class,
			@RequestParam("Price") Integer Price, 
			@RequestParam("setRent_fee") Integer setRent_fee,
			@RequestParam("photoFile") MultipartFile file) {
		try {
			ProductBean pb = new ProductBean();
			pb.setName(fileName);
			pb.setContext(Context);
			pb.setProduct_class(Product_class);
			pb.setPrice(Price);
			pb.setRent_fee(setRent_fee);
			pb.setImg(file.getBytes());

			pService.insertProduct(pb);

			return "上傳成功";
		} catch (IOException e) {
			e.printStackTrace();
			return "上傳失敗";
		}
	}

}
