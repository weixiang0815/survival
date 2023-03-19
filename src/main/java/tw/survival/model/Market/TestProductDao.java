package tw.survival.model.Market;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TestProductDao {

	// 若 query 語法是動態的，就用這個 DAO 寫法

	@PersistenceContext
	private EntityManager em; // Hibernate的 session

	// 多條件查詢
	@SuppressWarnings("null")
	public List<ProductBean> findProductText2(String name, String[] productclass, String context) {
		StringBuilder sql = new StringBuilder("SELECT * FROM Product WHERE ");
		boolean flag1 = name != null && !name.contentEquals("");
		sql.append(flag1 ? "name LIKE '%" + name + "%' " : "");
		boolean flag2 = productclass != null && productclass.length != 0;
		if (flag2) {
			sql.append(flag1 ? "AND " : "");
			sql.append("class IN ( ");
			for (int i = 0; i < productclass.length; i++) {
				sql.append("'" + productclass[i] + "'");
				sql.append(i != productclass.length - 1 ? ", " : " ) ");
			}
		}
		boolean flag3 = context != null && !context.contentEquals("");
		if (flag3) {
			sql.append(flag1 || flag2 ? "AND " : "");
			sql.append("context LIKE '%" + context + "%'");
		}
		Query query = em.createNativeQuery(sql.toString(), ProductBean.class);
		@SuppressWarnings("unchecked")
		List<ProductBean> resultList = query.getResultList();
		return resultList;
	}


}