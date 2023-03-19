package tw.survival.model.Market;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class LogisticsDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<LogisticsBean> multiSearch(String[] conditions) {
		TypedQuery<LogisticsBean> query = (TypedQuery<LogisticsBean>) em.createNativeQuery(sql(conditions),
				LogisticsBean.class);
		return query.getResultList();
	}

	private String sql(String[] conditions) {
		StringBuilder sql = new StringBuilder(" select * from Logistics where ");
		if (conditions != null && conditions.length != 0) {
			sql.append("status in (");
			for (int i = 0; i < conditions.length; i++) {
				sql.append("'" + conditions[i] + "'");
				sql.append(i == conditions.length - 1 ? ")" : ", ");
			}
		} else {
			sql.append("1 = 2");
		}
		sql.append(";");
		return sql.toString();
	}

}