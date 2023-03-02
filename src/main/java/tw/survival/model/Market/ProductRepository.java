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
	
//	@Query(value = "select * from Product where if(?1 !='',name=?,1=1) and if(?2 !='',class=?,1=1)"+"and if(?3 !='',context=?,1=1)",nativeQuery = true)
//	public List<ProductBean> findProductText(String name,String productclass,String context);
	
//	@Query(value = "select * from Product where class in %:class%",nativeQuery = true)
//	public List<ProductBean> findProductIn(@Param("class") String clazz);
	
	@Query(value = "from ProductBean where productclass like %:productclass%")
	public List<ProductBean> findProductClassLike(@Param("productclass") String clazz);
	
	
	
}
