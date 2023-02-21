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

	public void insertProduct(ProductBean ip) {
		productDao.save(ip);
	}

	public ProductBean findById(Integer id) {
		Optional<ProductBean> optional = productDao.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}
		System.out.println("沒找到id 為" + id + "的資料");
		return null;
	}

	public List<ProductBean> findAllProduct() {
		return productDao.findAll();
	}

	public ProductBean getProductById(Integer id) {
		Optional<ProductBean> optional = productDao.findById(id);

		if (optional.isPresent()) { // 判斷optional有東西
			return optional.get();
		}
		return null;
	}

	public ProductBean updateMsgById(Integer id, String updateName, byte[] updateImg, String updateContext,
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

	public void deleteById(Integer id) {
		ProductBean pb = findById(id);
		pb.setInventory(null);
		productDao.deleteById(id);
		return;
	}

	public void deleteByEntity(ProductBean msg) {
		productDao.delete(msg);
	}

	public List<ProductBean> findByName(String name) {
		return productDao.findProductLike(name);
	}

}
