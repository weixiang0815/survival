package tw.survival.model.Market;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TestProductDao {

	// 若 query 語法是動態的，就用這個 DAO 寫法

	@PersistenceContext
	private EntityManager em; // Hibernate的 session

	public List<ProductBean> someSQL(List<String> product_class) {
		TypedQuery<ProductBean> query = em.createQuery("sqlString", ProductBean.class);
		String sqlString ="from ProductBean where class in";
		if (product_class != null && !product_class.isEmpty()) {
			
		}else if(product_class.contains("手槍")){
			sqlString +="手槍";
		}else if(product_class.contains("步槍")){
			sqlString +="步槍";
		}else if(product_class.contains("衝鋒槍")){
			sqlString +="衝鋒槍";
		}else if(product_class.contains("狙擊槍")){
			sqlString +="狙擊槍";
		}else if(product_class.contains("霰彈槍")){
			sqlString +="霰彈槍";
		}
		return query.getResultList();

	}

}
