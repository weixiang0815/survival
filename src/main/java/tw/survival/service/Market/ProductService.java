package tw.survival.service.Market;

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
	
	public ProductBean insertProduct(ProductBean ip) {
		
		return productDao.save(ip);
	}
	

}
