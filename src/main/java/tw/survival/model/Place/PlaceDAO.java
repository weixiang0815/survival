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
public class PlaceDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public PlaceDAO() {
	}
	
	
	public PlaceBean addPlace(PlaceBean place) {
		Session session = sessionFactory.getCurrentSession();
		if (place != null) {
			session.save(place);
		}
		return place;
	}
	
	
	public PlaceBean getOnePlaceById(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		String hqlstr = "from PlaceBean where id = :id";
		
		Query<PlaceBean> query = session.createQuery(hqlstr, PlaceBean.class);
	
		query.setParameter("id", id);
		
		return query.uniqueResult();
	}
	

	public PlaceBean getOnePlaceByName(String place_name) {
		
		Session session = sessionFactory.getCurrentSession();
		
		String hqlstr = "from PlaceBean where place_name = :place_name";
		
		Query<PlaceBean> query = session.createQuery(hqlstr, PlaceBean.class);
	
		query.setParameter("place_name", place_name);
		
		return query.uniqueResult();
	}
	
	

	public List<PlaceBean> getAllPlace() {
		
		Session session = sessionFactory.getCurrentSession();
		
		String hqlstr = "from PlaceBean";
		
		Query<PlaceBean> query = session.createQuery(hqlstr, PlaceBean.class);
	
		List<PlaceBean> resultList = query.getResultList();
		
		return resultList;
	}
	
	
	public boolean deletePlaceByBean(PlaceBean place) {
		Session session = sessionFactory.getCurrentSession();
		if (place != null) {
			session.delete(place);
			System.out.println("place deleted.");

			return true;
		}

		return false;
	}
	
	
	public String deletePlaceById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
	    String hqlstr = "delete PlaceBean where id = :id";
	    int result = session.createQuery(hqlstr).setParameter("id", id).executeUpdate();
	    return result > 0 ? "刪除成功🤪🤪🤪" : "刪除失敗😥😥😥";

	}
	
	public boolean updatePlace(PlaceBean place) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(place);
			System.out.println("更新成功");
			return true;
		} catch (NoResultException e) {
			System.out.println("更新失敗");
			return false;
		}
		
	}
}
