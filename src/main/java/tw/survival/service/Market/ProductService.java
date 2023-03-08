package tw.survival.service.Market;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Market.ProductBean;
import tw.survival.model.Market.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productDao;

	//新增商品
	public void insertProduct(ProductBean ip) {
		productDao.save(ip);
	}

	//用ID找商品
	public ProductBean findById(Integer id) {
		Optional<ProductBean> optional = productDao.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}
		System.out.println("沒找到id 為" + id + "的資料");
		return null;
	}

	// 找全部商品
	public List<ProductBean> findAllProduct() {
		return productDao.findAll();
	}

	// 用ID找商品
	public ProductBean getProductById(Integer id) {
		Optional<ProductBean> optional = productDao.findById(id);

		if (optional.isPresent()) { // 判斷optional有東西
			return optional.get();
		}
		return null;
	}

	// 更新商品
	public ProductBean updateProductById(Integer id, String updateName, byte[] updateImg, String updateContext,
			String updateClass, Integer updateRent_fee, Integer updatePrice) {
		Optional<ProductBean> optional = productDao.findById(id);

		if (optional.isPresent()) {
			ProductBean pb = optional.get();
			pb.setName(updateName);
			pb.setImg(updateImg);
			pb.setProduct_class(updateClass);
			pb.setContext(updateContext);
			pb.setRent_fee(updateRent_fee);
			pb.setPrice(updatePrice);
			return pb;
		}

		System.out.println("沒有這筆資料");

		return null;
	}

	//用ID刪除商品
	public void deleteById(Integer id) {
		ProductBean pb = findById(id);
		pb.setInventory(null);
		productDao.deleteById(id);
		return;
	}

	//刪除商品
	public void deleteByEntity(ProductBean msg) {
		productDao.delete(msg);
	}

	//用商品名稱搜尋
	public List<ProductBean> findByName(String name) {
		return productDao.findProductNameLike(name);
	}
	
	//用商品種類搜尋
		public List<ProductBean> findByClazz(String clazz) {
			return productDao.findProductClassLike(clazz);
		}

//	public List<ProductBean> findProductText2(String name,String productclass,String context) {
//		return productDao.findProductText(name,productclass,context);
//	}


}