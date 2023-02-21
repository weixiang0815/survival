package tw.survival;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tw.survival.model.Market.ProductBean;
import tw.survival.model.Market.TestProductDaoText;

@Component
class SurvivalRunner implements ApplicationRunner	 {

	@Autowired
	private TestProductDaoText tpdt;	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<String> al =new ArrayList<>();
		al.add("手槍");
		List<ProductBean> fd =tpdt.findByproductclassIn(al);
		System.out.println(fd);
	}

}
