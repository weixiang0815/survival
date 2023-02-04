package tw.survival.model.Place;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ScheduleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ScheduleDAO() {

	}

	public ScheduleBean addSchedule(ScheduleBean schedule) {
		Session session = sessionFactory.getCurrentSession();
		if(schedule != null) {
			session.save(schedule);
		}
		return schedule;
	}
	
	public ScheduleBean getOneScheduleById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = "from ScheduleBean where id = :id";
		Query<ScheduleBean> query = session.createQuery(hqlstr,ScheduleBean.class);
	    query.setParameter("id", id);
	    return query.uniqueResult();
	}
	
	public List<ScheduleBean> getAllSchedule(){
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = "from ScheduleBean";
		Query<ScheduleBean> query = session.createQuery(hqlstr,ScheduleBean.class);
		List<ScheduleBean> resultList = query.getResultList();
		return resultList;
	}
	
	public String deleteScheduleById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = "delete ScheduleBean where id = :id";
		int result = session.createQuery(hqlstr).setParameter("id", id).executeUpdate();
		return result > 0 ? "刪除成功🤪🤪🤪" : "刪除失敗😥😥😥";
	}
	
	public boolean updateSchedule(ScheduleBean schedule) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(schedule);
			System.out.println("更新成功");
			return true;
		} catch (NoResultException e) {
			System.out.println("更新失敗");
			return false;
		}
	}
}
