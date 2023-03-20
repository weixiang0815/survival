package tw.survival.controller.front.R.Market;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@GetMapping("/front/Market/index")
	public String goIndex() {
		return "front/Market/index";
	}
	
	// 搜尋前臺全部商品
	@GetMapping("/front/Market/getAllProductFront")
	public String getAllProductFront(Model model) {
		List<ProductBean> list = productService.findAllProduct();
		model.addAttribute("list", list);
		return "/front/Market/shop";
	}

	@GetMapping("/front/Market/Text")
	public String getAllProduct1(Model model) {
		List<ProductBean> list = productService.findAllProduct();
		model.addAttribute("list", list);
		return "/front/Market/Text";
	}

	// 用ID找商品
	@GetMapping("/front/Market/productId")
	public String getProductId(@RequestParam("id") Integer id, Model model) {
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
				sql.append("context LIKE '%" + context[i] + "%'");
				sql.append(i != context.length - 1 ? " OR " : " ) ");
			}
		}
		boolean flag3 = priceRange != null && priceRange.length != 0;
		if (flag3) {
			for (String pr : priceRange) {
				System.out.println(pr);
			}
			sql.append(flag1 || flag2 ? "AND (" : "(");
			for (int i = 0; i < priceRange.length; i++) {
				switch (priceRange[i]) {
				case "low":
					// 小於5000
					sql.append(" ( price BETWEEN 0 AND 5000 ) ");
					break;
				case "mid":
					// 5000到9000
					sql.append(" ( price BETWEEN 5000 AND 9000 ) ");
					break;
				case "high":
					// 9000以上
					sql.append(" ( price BETWEEN 9000 AND 100000 ) ");
					break;
				}
				sql.append(i != priceRange.length - 1 ? "or " : " ) ");
			}
		}
		if (!flag1 && !flag2 && !flag3) {
			sql.append("1=1");
		}
		System.out.println(sql);
		Query query = em.createNativeQuery(sql.toString(), ProductBean.class);
		@SuppressWarnings("unchecked")
		List<ProductBean> resultList = query.getResultList();
		return resultList;
	}

}