package tw.survival.model.Market;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
		String sqlString = "from ProductBean where class in";
		if (product_class != null && !product_class.isEmpty()) {

		} else if (product_class.contains("手槍")) {
			sqlString += "手槍";
		} else if (product_class.contains("步槍")) {
			sqlString += "步槍";
		} else if (product_class.contains("衝鋒槍")) {
			sqlString += "衝鋒槍";
		} else if (product_class.contains("狙擊槍")) {
			sqlString += "狙擊槍";
		} else if (product_class.contains("霰彈槍")) {
			sqlString += "霰彈槍";
		}
		TypedQuery<ProductBean> query = em.createQuery(sqlString, ProductBean.class);
		return query.getResultList();
	}

	public List<ProductBean> findProductText(String name, String productclass, String context) {
		String sql = "SELECT * FROM Product WHERE IF(?1 != '', name LIKE CONCAT('%',?,'%'), 1=1) AND IF(?2 != '', class = ?, 1=1) AND IF(?3 != '', context LIKE CONCAT('%',?,'%'), 1=1)";		Query query = em.createNativeQuery(sql, ProductBean.class);
		query.setParameter(1, name);
		query.setParameter(2, productclass);
		query.setParameter(3, context);
		@SuppressWarnings("unchecked")
		List<ProductBean> resultList = query.getResultList();
		return resultList;
	}

}