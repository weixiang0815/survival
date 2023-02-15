package tw.survival.controller.Market;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
			@RequestParam("photoContext") String Context, @RequestParam("Product_class") String Product_class,
			@RequestParam("Price") Integer Price, @RequestParam("setRent_fee") Integer setRent_fee,
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
	
	@GetMapping("/Market/allProduct")
	public ModelAndView getAllProduct(ModelAndView mav) {
		List<ProductBean> list = pService.findAllProduct();
		mav.setViewName("/Market/show_AllProduct");
		mav.getModel().put("list", list);
		return mav;
	}
	
	@ResponseBody
	@GetMapping("/Market/id")
	public ResponseEntity<byte[]> getProductById(@RequestParam Integer id){
		ProductBean photo = pService.getProductById(id);
		
		
		byte[] photoFile = photo.getImg();
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.IMAGE_JPEG);
        //ResponseEntity 內建 @ResponseBody   // 資料, headers, 回應的 http status
		return new ResponseEntity<byte[]>(photoFile,headers,HttpStatus.OK);
		
	}
	@GetMapping("/Market/edit")
	public String editMessagePage(@RequestParam("id") Integer id, Model model) {
		ProductBean p1 = pService.findById(id);
		model.addAttribute("product", p1);
		return "Market/editProduct";
	}
	@PostMapping("/Market/edit")
	public String sendEditedMessage(@RequestParam("id") Integer id,@RequestParam("name") String name,
			@RequestParam("img")MultipartFile img,@RequestParam("product_class") String product_class,
			@RequestParam("context")String context,@RequestParam("rent_fee")Integer rent_fee,
			@RequestParam("price") Integer price) {
		
		try {
			pService.updateMsgById(id, name,  img.getBytes(),product_class, context, rent_fee, price);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/Market/allProduct";
	}
	@DeleteMapping("/Market/delete")
	public String deleteProdduct(@RequestParam("id") Integer id) {
		pService.deleteById(id);
		return "redirect:/Market/allProduct";
	}
	
}
