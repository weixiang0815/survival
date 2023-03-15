package tw.survival.controller.Market;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import tw.survival.model.Market.ProductBean;
import tw.survival.model.Market.ProductRepository;
import tw.survival.model.Market.ProductSearchDto;
import tw.survival.model.Market.TestProductDao;
import tw.survival.service.Market.ProductService;

@Controller
public class ProductController {

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
	public ModelAndView getAllProduct(ModelAndView mav) {
		List<ProductBean> list = productService.findAllProduct();
		mav.setViewName("back/Market/show_AllProduct");
		mav.getModel().put("list", list);
		return mav;
	}

	// 搜尋前臺全部商品
	@GetMapping("/front/Market/getAllProductFront")
	public ModelAndView getAllProductFront(ModelAndView mav) {
		List<ProductBean> list = productService.findAllProduct();
		mav.setViewName("/front/Market/shop");
		mav.getModel().put("list", list);
		return mav;
	}

	@GetMapping("/front/Market/Text")
	public ModelAndView getAllProduct1(ModelAndView mav) {
		List<ProductBean> list = productService.findAllProduct();
		mav.setViewName("/front/Market/Text");
		mav.getModel().put("list", list);
		return mav;
	}

	// 用ID找商品
	@GetMapping("/front/Market/productId")
	public String getAllProduct1(@RequestParam("id") Integer id, Model model) {
		ProductBean product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "/front/Market/productDetail";
	}

	// 搜尋商品 by ID 的圖片
	@ResponseBody
	@GetMapping("/Market/id")
	public ResponseEntity<byte[]> getProductById(@RequestParam("id") Integer id) {
		ProductBean photo = productService.getProductById(id);

		byte[] photoFile = photo.getImg();
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.IMAGE_JPEG);
		// ResponseEntity 內建 @ResponseBody // 資料, headers, 回應的 http status
		return new ResponseEntity<byte[]>(photoFile, headers, HttpStatus.OK);
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
	public String deleteProdduct(@RequestParam("id") Integer id) {
		productService.deleteById(id);
		return "redirect:/Market/allProduct";
	}

	// 模糊搜尋商品
	@GetMapping("/Market/productNameLike")
	public String findProductLike(@RequestParam("Search") String name, Model model) {
		List<ProductBean> searchResult = productService.findByName(name);
		model.addAttribute("SearchResult", searchResult);
		return "front/Market/searchResult";
	}

//	 搜尋類型商品>>ProductRepository>>findProductClassLike
	@GetMapping("/Market/findProductClassLike")
	public String findProductClassLike(@RequestParam("product_class") String clazz, Model model) {
		List<ProductBean> searchResult = productDao.findProductClassLike(clazz);
		model.addAttribute("SearchResult2", searchResult);
		return "front/Market/searchResult2";
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
	// 多條件

	@ResponseBody
	@GetMapping("Market/multicondition")
	public List<ProductBean> multicondition(@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "productclass", defaultValue = "") String[] productclass,
			@RequestParam(name = "context", defaultValue = "") String context) {
		return TestDao.findProductText2(name, productclass, context);
	}

	// 圖片處理
	@ResponseBody
	@GetMapping("/Market/productImage")
	public Map<String, String> getProductImage(@RequestParam("productId") Integer productId) {
		ProductBean product = productService.getProductById(productId);
		Map<String, String> imageMap = new HashMap<>();
		if (product != null && product.getImg() != null) {
			String imageData = Base64.getEncoder().encodeToString(product.getImg());
			imageMap.put("imageData", imageData);
		}

		return imageMap;
	}

	// 多選 多條件搜尋
	@ResponseBody
	@PostMapping("/Market/multisearch2") // 多條件搜尋
	public List<ProductBean> findProductByMultiSearch2(@RequestBody ProductSearchDto dto) {
		String[] clazz = dto.getClazz();
		String[] context = dto.getContext();
		String[] priceRange = dto.getPriceRange();

		StringBuilder sql = new StringBuilder("SELECT * FROM Product WHERE ");
		boolean flag1 = clazz != null && clazz.length != 0;
		if (flag1) {
			for (String gen : clazz) {
				System.out.println(gen);
			}
			sql.append("class IN (");
			for (int i = 0; i < clazz.length; i++) {
				sql.append("'" + clazz[i] + "'");
				sql.append(i != clazz.length - 1 ? " , " : " ) ");
			}
		}
		boolean flag2 = context != null && context.length != 0;
		if (flag2) {
			for (String cla : context) {
				System.out.println(cla);
			}
			sql.append(flag1 ? "AND (" : "(");
			for (int i = 0; i < context.length; i++) {
				sql.append("context LIKE N'%" + context[i] + "%'");
				sql.append(i != context.length - 1 ? " OR " : " ) ");
			}
		}
		boolean flag3 = priceRange != null && priceRange.length != 0;
		if (flag3) {
			for (String pr : priceRange) {
				System.out.println(pr);
			}
			sql.append(flag1 || flag2 ? "AND (" : "(");
			boolean flag = false;
			for (int i = 0; i < priceRange.length; i++) {
				if (flag) {
					sql.append("or");
				}
				//小於5000
				if (priceRange[i].equals("low")) {
					sql.append(" price BETWEEN 0 AND 5000 ");
					flag = true;
				}
				//5000到9000
				if (priceRange[i].equals("mid")) {
					sql.append(" price BETWEEN 5000 AND 9000 ");
					flag = true;
				}
				//9000以上
				if (priceRange[i].equals("high")) {
					sql.append(" price BETWEEN 9000 AND 99999999999 ");
					flag = true;
				}
				sql.append(i != priceRange.length - 1 ? "" : " ) ");
			}
		}
		if (flag1 || flag2 || flag3) {
			sql.append(";");
		} else {
			sql.append("1=2");
		}
		System.out.println(sql);
		Query query = em.createNativeQuery(sql.toString(), ProductBean.class);
		@SuppressWarnings("unchecked")
		List<ProductBean> resultList = query.getResultList();
		return resultList;
	}

//	@ResponseBody
//	@GetMapping("/Market/productFindByproductclassIn")
//	public String findByproductclassIn(@RequestParam("product_class") List<String> clazz, Model model) {
//		List<ProductBean> searchResult = productService.findByClass(clazz);
//		model.addAttribute("SearchResult2", searchResult);
//		return "Market/serchResult";
//	}

}