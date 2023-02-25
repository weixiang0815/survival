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
	 * 將傳入的各種條件動態轉換為 HQL 語句
	 * 
	 * @param condititons 查詢依據的各種條件
	 * @return 轉換好的 HQL 語句字串
	 * @author 王威翔
	 * @throws ParseException
	 */
	public String hql(CompetitionSearchCondititonsDto conditions) {
		StringBuilder hql = new StringBuilder("select * from CompetitionBean as c ");
		hql.append("where 1=1 ");
		String mandarinName = conditions.getMandarinName();
		if (mandarinName != null && !mandarinName.trim().contentEquals("")) {
			hql.append("and c.mandarinName like '%");
			hql.append(mandarinName);
			hql.append("%' ");
		}
		System.out.println(hql.toString());
		String englishName = conditions.getEnglishName();
		if (englishName != null && !englishName.trim().contentEquals("")) {
			hql.append("and c.englishName like '%");
			hql.append(englishName);
			hql.append("%' ");
		}
		System.out.println(hql.toString());
		List<Integer> place = conditions.getPlace();
		if (place != null && place.size() != 0) {
			hql.append("and c.placeId in (");
			for (int i = 0; i < place.size(); i ++) {
				hql.append(place.get(i));
				hql.append(i == place.size() - 1 ? "" : ", ");
			}
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<String> singleOrCrew = conditions.getSingleOrCrew();
		if (singleOrCrew != null && singleOrCrew.size() != 0) {
			hql.append("and c.singleOrCrew in (");
			for(int i = 0; i < singleOrCrew.size(); i ++) {
				hql.append("'" + singleOrCrew.get(i) + "'");
				hql.append(i == singleOrCrew.size() - 1 ? "" : ", ");
			}
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<String> status = conditions.getStatus();
		if (status != null && status.size() != 0) {
			hql.append("and c.status in (");
			for (int i = 0; i < status.size(); i ++) {
				hql.append("'" + status.get(i) + "'");
				hql.append(i == status.size() - 1 ? "" : ", ");
			}
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<Integer> capacity = conditions.getCapacity();
		if (capacity != null && capacity.size() != 0) {
			hql.append("and c.capacity in (");
			for (int i = 0; i < capacity.size(); i ++) {
				hql.append(capacity.get(i));
				hql.append(i == capacity.size() - 1 ? "" : ", ");
			}
			hql.append(") ");
		}
		List<Integer> budget = conditions.getBudget();
		if (budget != null && budget.size() != 0) {
			hql.append("and c.budget in (");
			for (int i = 0; i < budget.size(); i ++) {
				hql.append(budget.get(i));
				hql.append(i == budget.size() - 1 ? "" : ", ");
			}
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<Integer> fee = conditions.getFee();
		if (fee != null && fee.size() != 0) {
			hql.append("and c.fee in (");
			for (int i = 0; i < fee.size() - 1; i ++) {
				hql.append(fee.get(i));
				hql.append(i == fee.size() - 1 ? "" : ", ");
			}
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<Integer> publicOrPrivate = conditions.getPublicOrPrivate();
		if (publicOrPrivate != null && publicOrPrivate.size() != 0) {
			hql.append("and c.publicOrPrivate in (");
			for (int i = 0; i < publicOrPrivate.size(); i ++) {
				hql.append(publicOrPrivate.get(i));
				hql.append(i == publicOrPrivate.size() ? "" : ", ");
			}
			hql.append(") ");
		}
		System.out.println(hql.toString());
		String date = conditions.getDate();
		if (date != null && !date.trim().contentEquals("")) {
			hql.append("and c.startDate <= '");
			hql.append(date);
			hql.append("' and c.endDate >= '");
			hql.append(date);
			hql.append("' ");
		}
		System.out.println(hql.toString());
		return hql.toString();
	}

}