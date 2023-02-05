package tw.survival.model.Market;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Market.ProductBean;

@Service
public class ProductService {
	
	@Autowired
	ProductBean productDao;
	
	public List<ProductBean> getTodosByUserId(Integer id) {
		return null;
//		List<ProductBean> data = productDao.;
//        return data;
	}
}
