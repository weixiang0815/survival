package tw.survival.model.Competition;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	 * 針對前台的多條件查詢活動結果
	 * 
	 * @param conditions 查詢依據的各種條件
	 * @return 裝著活動實體的 List 物件
	 * @author 王威翔
	 */
	@SuppressWarnings("unchecked")
	public List<CompetitionBean> multiconditionSearchFront(CompetitionSearchCondititonsDto conditions) {
		TypedQuery<CompetitionBean> query = (TypedQuery<CompetitionBean>) em.createNativeQuery(sqlFront(conditions),
				CompetitionBean.class);
		return query.getResultList();
	}

	/**
	 * 針對後台的多條件查詢活動結果
	 * 
	 * @param conditions 查詢依據的各種條件
	 * @return 裝著活動實體的 List 物件
	 * @author 王威翔
	 */
	public List<CompetitionBean> multiconditionSearchBack(CompetitionSearchCondititonsDto conditions) {
		TypedQuery<CompetitionBean> query = em.createQuery(hqlBack(conditions), CompetitionBean.class);
		return query.getResultList();
	}

	/**
	 * 將針對前台傳入的各種條件動態轉換為 HQL 語句
	 * 
	 * @param condititons 查詢依據的各種條件
	 * @return 轉換好的 HQL 語句字串
	 * @author 王威翔
	 */
	@SuppressWarnings("null")
	public String sqlFront(CompetitionSearchCondititonsDto conditions) {
		StringBuilder sql = new StringBuilder("select * from Competition as c where ");
		// 將會用到的成員屬性一一呼叫出來
		String mandarinName = conditions.getMandarinName();
		String englishName = conditions.getEnglishName();
		List<Integer> place = conditions.getPlace();
		List<String> date = conditions.getDate();
		List<String> singleOrCrew = conditions.getSingleOrCrew();
		List<Integer> fee = conditions.getFee();
		List<Integer> capacity = conditions.getCapacity();
		// 判斷各成員屬性是否存在並令成布林值變數
		boolean flag1 = mandarinName != null && !mandarinName.trim().contentEquals("");
		boolean flag2 = englishName != null && !englishName.trim().contentEquals("");
		boolean flag3 = place != null && place.size() != 0;
		boolean flag4 = date != null && date.size() != 0;
		boolean flag5 = singleOrCrew != null && singleOrCrew.size() != 0;
		boolean flag6 = fee != null && fee.size() != 0;
		boolean flag7 = capacity != null && capacity.size() != 0;
		// 判斷輸入的中文名稱與英文名稱成員屬性是否存在
		if (flag1) {
			sql.append("( c.name_mandarin like '%" + mandarinName + "%' ");
			sql.append("or ");
			sql.append("c.name_english like '%" + englishName + "%' ) ");
		}
		// 判斷輸入的地點編號成員屬性是否存在，同時判斷前者成員屬性是否存在
		if (flag3) {
			if (flag1 || flag2) {
				sql.append("and ");
			}
			sql.append("c.fk_place_id in ( ");
			for (int i = 0; i < place.size(); i++) {
				sql.append(place.get(i));
				sql.append(i == place.size() - 1 ? " ) " : ", ");
			}
		}
		// 判斷輸入的日期成員屬性是否存在，同時判斷前者成員屬性是否存在
		if (flag4) {
			if (flag1 || flag2 || flag3) {
				sql.append("and ");
			}
			sql.append("( ");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String today = formatter.format(new Date());
			for (int i = 0; i < date.size(); i++) {
				switch (date.get(i)) {
				case "notyet":
					sql.append("( c.start_date > '" + today + "' ) ");
					break;
				case "ing":
					sql.append("( c.start_date <= '" + today + "' and c.end_date >= '" + today + "' ) ");
					break;
				case "ended":
					sql.append("( c.end_date < '" + today + "' ) ");
					break;
				}
				sql.append(i == date.size() - 1 ? ") " : "or ");
			}
		}
		// 判斷輸入的競賽模式成員屬性是否存在，同時判斷前者成員屬性是否存在
		if (flag5) {
			if (flag1 || flag2 || flag3 || flag4) {
				sql.append("and ");
			}
			sql.append("c.single_or_crew in ( ");
			for (int i = 0; i < singleOrCrew.size(); i++) {
				sql.append("'" + singleOrCrew.get(i) + "' ");
				sql.append(i == singleOrCrew.size() - 1 ? ") " : ", ");
			}
		}
		// 判斷輸入的報名費用成員屬性是否存在，同時判斷前者成員屬性是否存在
		if (flag6) {
			if (flag1 || flag2 || flag3 || flag4 || flag5) {
				sql.append("and ");
			}
			sql.append("( ");
			for (int i = 0; i < fee.size(); i++) {
				switch (fee.get(i)) {
				case 0:
					sql.append("( c.fee = 0 ) ");
					break;
				case 1:
					sql.append("( c.fee > 0 and c.fee <= 1000 ) ");
					break;
				case 2:
					sql.append("( c.fee > 1000 ) ");
				}
				sql.append(i == fee.size() - 1 ? ") " : "or ");
			}
		}
		if (flag7) {
			if (flag1 || flag2 || flag3 || flag4 || flag5 || flag6) {
				sql.append("and ");
			}
			sql.append("( ");
			for (int i = 0; i < capacity.size(); i++) {
				switch (capacity.get(i)) {
				case 0:
					sql.append("( c.capacity <= 30 ) ");
					break;
				case 1:
					sql.append("( c.capacity > 30 and c.capacity <= 100 ) ");
					break;
				case 2:
					sql.append("( c.capacity > 100 ) ");
					break;
				}
				sql.append(i == capacity.size() - 1 ? ") " : "or ");
			}
		}
		System.out.println(sql.toString());
		return sql.toString();
	}

	/**
	 * 將針對後台傳入的各種條件動態轉換為 HQL 語句
	 * 
	 * @param condititons 查詢依據的各種條件
	 * @return 轉換好的 HQL 語句字串
	 * @author 王威翔
	 * @throws ParseException
	 */
	public String hqlBack(CompetitionSearchCondititonsDto conditions) {
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
			for (int i = 0; i < place.size(); i++) {
				hql.append(place.get(i));
				hql.append(i == place.size() - 1 ? "" : ", ");
			}
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<String> singleOrCrew = conditions.getSingleOrCrew();
		if (singleOrCrew != null && singleOrCrew.size() != 0) {
			hql.append("and c.singleOrCrew in (");
			for (int i = 0; i < singleOrCrew.size(); i++) {
				hql.append("'" + singleOrCrew.get(i) + "'");
				hql.append(i == singleOrCrew.size() - 1 ? "" : ", ");
			}
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<String> status = conditions.getStatus();
		if (status != null && status.size() != 0) {
			hql.append("and c.status in (");
			for (int i = 0; i < status.size(); i++) {
				hql.append("'" + status.get(i) + "'");
				hql.append(i == status.size() - 1 ? "" : ", ");
			}
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<Integer> capacity = conditions.getCapacity();
		if (capacity != null && capacity.size() != 0) {
			hql.append("and c.capacity in (");
			for (int i = 0; i < capacity.size(); i++) {
				hql.append(capacity.get(i));
				hql.append(i == capacity.size() - 1 ? "" : ", ");
			}
			hql.append(") ");
		}
		List<Integer> budget = conditions.getBudget();
		if (budget != null && budget.size() != 0) {
			hql.append("and c.budget in (");
			for (int i = 0; i < budget.size(); i++) {
				hql.append(budget.get(i));
				hql.append(i == budget.size() - 1 ? "" : ", ");
			}
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<Integer> fee = conditions.getFee();
		if (fee != null && fee.size() != 0) {
			hql.append("and c.fee in (");
			for (int i = 0; i < fee.size() - 1; i++) {
				hql.append(fee.get(i));
				hql.append(i == fee.size() - 1 ? "" : ", ");
			}
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<Integer> publicOrPrivate = conditions.getPublicOrPrivate();
		if (publicOrPrivate != null && publicOrPrivate.size() != 0) {
			hql.append("and c.publicOrPrivate in (");
			for (int i = 0; i < publicOrPrivate.size(); i++) {
				hql.append(publicOrPrivate.get(i));
				hql.append(i == publicOrPrivate.size() ? "" : ", ");
			}
			hql.append(") ");
		}
		System.out.println(hql.toString());
		List<String> date = conditions.getDate();
		if (date != null) {
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