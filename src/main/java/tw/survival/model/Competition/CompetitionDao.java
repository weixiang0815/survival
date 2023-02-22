package tw.survival.model.Competition;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CompetitionDao {

	@PersistenceContext
	private EntityManager em;

	/**
	 * 多條件查詢活動結果
	 * 
	 * @param conditions 查詢依據的各種條件
	 * @return 裝著活動實體的 List 物件
	 * @author 王威翔
	 */
	public List<CompetitionBean> multiconditionSearch(CompetitionSearchCondititonsDto conditions) {
		TypedQuery<CompetitionBean> query = em.createQuery(sql(conditions), CompetitionBean.class);
		return query.getResultList();
	}

	/**
	 * 將傳入的各種條件動態轉換為 SQL 語句
	 * 
	 * @param condititons 查詢依據的各種條件
	 * @return 轉換好的 SQL 語句字串
	 * @author 王威翔
	 */
	public String sql(CompetitionSearchCondititonsDto conditions) {
		StringBuilder sql = new StringBuilder("select * from Competition ");
		sql.append("where 1=1 ");
		return sql.toString();
	}

}