package tw.survival.model.Competition;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CompetitionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 新增一筆活動資料
	 * 
	 * @param comp 欲新增的 CompetitionBean
	 * 
	 * @return 回傳傳入的 CompetitionBean
	 */
	public CompetitionBean addCompetition(CompetitionBean comp) {
		Session session = sessionFactory.getCurrentSession();
		if (comp != null) {
			session.save(comp);
		}
		return comp;
	}

	/**
	 * 透過 CompetitionBean 刪除一筆活動資料
	 * 
	 * @param comp 欲刪除資料的 CompetitionBean
	 * 
	 * @return 刪除成功回傳 true，否則回傳 false
	 */
	public boolean deleteCompetitionByBean(CompetitionBean comp) {
		Session session = sessionFactory.getCurrentSession();

		if (comp != null) {
			session.delete(comp);
			System.out.println("Competition deleted.");

			return true;
		}

		return false;
	}

	/**
	 * 透過 id 刪除一筆活動資料
	 * 
	 * @param id 欲刪除資料的活動 id
	 * 
	 * @return 刪除成功回傳 true，否則回傳 false
	 */
	public String deleteCompetitionById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = "delete CompetitionBean where id = :id";
		int result = session.createQuery(hqlstr).setParameter("id", id).executeUpdate();
		return result > 0 ? "刪除成功🤪🤪🤪" : "刪除失敗😥😥😥";
	}

	/**
	 * 更新一筆活動資料
	 * 
	 * @param comp 傳入欲更新資料的活動 CompetitionBean
	 * 
	 * @return 更新成功回傳 true，否則回傳 false
	 */
	public boolean updateCompetition(CompetitionBean comp) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(comp);
			System.out.println("更新成功");
			return true;
		} catch (NoResultException e) {
			System.out.println("更新失敗");
			return false;
		}
	}

	/**
	 * 透過 id 查詢一筆活動資料
	 * 
	 * @param id 欲查詢資料的活動 id
	 * 
	 * @return 回傳查到的 CompetitionBean
	 */
	public CompetitionBean getOneCompetitionById(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		String hqlstr = "from CompetitionBean where id = :id";
		Query<CompetitionBean> query = session.createQuery(hqlstr, CompetitionBean.class);
		query.setParameter("id", id);

		return query.uniqueResult();
	}

	/**
	 * 查詢所有活動資料
	 * 
	 * @return 回傳裝著所有 CompetitionBean 的列表
	 */
	public List<CompetitionBean> getAllCompetitions() {
		Session session = sessionFactory.getCurrentSession();

		String hqlstr = "from CompetitionBean";
		Query<CompetitionBean> query = session.createQuery(hqlstr, CompetitionBean.class);
		List<CompetitionBean> resultList = query.getResultList();

		return resultList;
	}

}