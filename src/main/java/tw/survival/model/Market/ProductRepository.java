package tw.survival.model.Market;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<ProductBean, Integer> {

//	 @Query(value="from ProductBean where name like %:name%")
//	 public List<ProductBean> findProductLike(@Param("name") String name);

	@Query(value = "from ProductBean where name like %:name%")
	public List<ProductBean> findProductLike(@Param("name") String name);

}
