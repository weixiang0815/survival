package tw.survival.model.Competition;

import java.text.ParseException;
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
		TypedQuery<CompetitionBean> query = em.createQuery(hql(conditions), CompetitionBean.class);
		return query.getResultList();
	}

	/**
	 * 將傳入的各種條件動態轉換為 SQL 語句
	 * 
	 * @param condititons 查詢依據的各種條件
	 * @return 轉換好的 SQL 語句字串
	 * @author 王威翔
	 * @throws ParseException
	 */
	public String hql(CompetitionSearchCondititonsDto conditions) {
		StringBuilder hql = new StringBuilder("select * from CompetitionBean ");
		hql.append("where 1=1 ");
		String mandarinName = conditions.getMandarinName();
		if (mandarinName != null && !mandarinName.trim().contentEquals("")) {
			hql.append("and mandarinName like [%");
			hql.append(mandarinName);
			hql.append("%] ");
		}
		System.out.println(hql.toString());
		String englishName = conditions.getEnglishName();
		if (englishName != null && !englishName.trim().contentEquals("")) {
			hql.append("and englishName like [%");
			hql.append(englishName);
			hql.append("%] ");
		}
		System.out.println(hql.toString());
		List<Integer> place = conditions.getPlace();
		if (place != null && place.size() != 0) {
			hql.append("and placeId in (");
			place.forEach(p -> hql.append(p + ", "));
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<String> singleOrCrew = conditions.getSingleOrCrew();
		if (singleOrCrew != null && singleOrCrew.size() != 0) {
			hql.append("and singleOrCrew in (");
			singleOrCrew.forEach(p -> hql.append("[" + p + "], "));
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<String> status = conditions.getStatus();
		if (status != null && status.size() != 0) {
			hql.append("and status in (");
			status.forEach(p -> hql.append("[" + p + "], "));
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<Integer> capacity = conditions.getCapacity();
		if (capacity != null && capacity.size() != 0) {
			hql.append("and capacity in (");
			capacity.forEach(p -> hql.append(p + ", "));
			hql.append(") ");
		}
		List<Integer> budget = conditions.getBudget();
		if (budget != null && budget.size() != 0) {
			hql.append("and budget in (");
			budget.forEach(p -> hql.append(p + ", "));
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<Integer> fee = conditions.getFee();
		if (fee != null && fee.size() != 0) {
			hql.append("and fee in (");
			fee.forEach(p -> hql.append(p + ", "));
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<Integer> publicOrPrivate = conditions.getPublicOrPrivate();
		if (publicOrPrivate != null && publicOrPrivate.size() != 0) {
			hql.append("and publicOrPrivate in (");
			publicOrPrivate.forEach(p -> hql.append(p + ", "));
			hql.append(") ");
		}
		System.out.println(hql.toString());
		String date = conditions.getDate();
		if (date != null && !date.trim().contentEquals("")) {
			hql.append("and startDate < [");
			hql.append(date);
			hql.append("] and endDate > [");
			hql.append(date);
			hql.append("] ");
		}
		System.out.println(hql.toString());
		return hql.toString();
	}

}