package tw.survival.controller.back.Market;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import tw.survival.model.Market.ProductBean;
import tw.survival.model.Market.ProductRepository;
import tw.survival.model.Market.TestProductDao;
import tw.survival.service.Market.ProductService;

@Controller
public class ProductControllerBack {

	@Autowired
	private ProductRepository productDao;

	@Autowired
	private ProductService productService;

	@Autowired
	private TestProductDao TestDao;

	@PersistenceContext
	private EntityManager em; // Hibernate的 session

	@GetMapping("/Market/add_Product")
	private String add_Product() {
		return "/back/Market/add_Product";
	}

	@GetMapping("/Market/show_AllProduct")
	private String showAllProfuct() {
		return "/back/Market/show_AllProduct";
	}

	// 新增商品
	@ResponseBody
	@PostMapping("/Market/addproduct")
	public String insertProduct(@RequestParam("ProductName") String fileName,
			@RequestParam("ProductContext") String Context, @RequestParam("Product_class") String Product_class,
			@RequestParam("Price") Integer Price, @RequestParam("setRent_fee") Integer setRent_fee,
			@RequestParam("ProductFile") MultipartFile file) {
		try {
			ProductBean pb = new ProductBean();
			pb.setName(fileName);
			pb.setContext(Context);
			pb.setProduct_class(Product_class);
			pb.setPrice(Price);
			pb.setRent_fee(setRent_fee);
			pb.setImg(file.getBytes());

			productService.insertProduct(pb);

			return "上傳成功";
		} catch (IOException e) {
			e.printStackTrace();
			return "上傳失敗";
		}
	}

	// 搜尋全部商品
	@GetMapping("/Market/allProduct")
	public String getAllProduct(Model model) {
		List<ProductBean> list = productService.findAllProduct();
		model.addAttribute("list", list);
		return "back/Market/show_AllProduct";
	}

	// 修改商品
	@GetMapping("/back/Market/edit")
	public String editProductPage(@RequestParam("id") Integer id, Model model) {
		ProductBean p1 = productService.findById(id);
		model.addAttribute("product", p1);
		return "/back/Market/editProduct";
	}

	// 修改商品
	@PostMapping("/back/Market/editProduct")
	public String sendEditedProduct(@RequestParam("id") Integer id, @RequestParam("name") String name,
			@RequestParam("img") MultipartFile img, @RequestParam("Product_class") String product_class,
			@RequestParam("context") String context, @RequestParam("rent_fee") Integer rent_fee,
			@RequestParam("price") Integer price) {

		try {
			productService.updateProductById(id, name, img.getBytes(), context, product_class, rent_fee, price);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/Market/allProduct";
	}

	// 刪除商品
	@DeleteMapping("back/Market/delete")
	public String deleteProduct(@RequestParam("id") Integer id) {
		productService.deleteById(id);
		return "redirect:/Market/allProduct";
	}

	// 測試後可行的多條件
	@GetMapping("/Market/productIn2")
	public String findProductIn(@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "productclass", defaultValue = "") String[] productclass,
			@RequestParam(name = "context", defaultValue = "") String context, Model model) {
		List<ProductBean> searchResult = TestDao.findProductText2(name, productclass, context);
		model.addAttribute("searchResult2", searchResult);
		return "/back/Market/searchResult2";
	}

}