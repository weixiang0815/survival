package tw.survival.model.Market;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestProductDaoText extends JpaRepository<ProductBean, Integer> {

	public List<ProductBean> findByProductclassIn(List<String> classes);

}