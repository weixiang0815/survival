package tw.survival.model.Place;

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
public class PlaceOrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public PlaceOrderBean addPlaceOrder(PlaceOrderBean plOrder) {
		Session session = sessionFactory.getCurrentSession();
		if(plOrder != null) {
			session.save(plOrder);
		}
		return plOrder;
	}

	public boolean deletePlaceOrderByBean(PlaceOrderBean plOrder) {
		Session session = sessionFactory.getCurrentSession();
		if (plOrder != null) {
			session.delete(plOrder);
			System.out.println("PlaceOrder deleted.");

			return true;
		}

		return false;
	}
	
	public String deletePlaceOrderById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = "delete from PlaceOrder where id = :id";
		int result = session.createQuery(hqlstr).setParameter("id", id).executeUpdate();
		return result > 0 ? "刪除成功🤪🤪🤪" : "刪除失敗😥😥😥";
	}
	
	
	public PlaceOrderBean getOnePlaceOrderById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = " from PlaceOrder where id = :id";
		Query<PlaceOrderBean>query = session.createQuery(hqlstr,PlaceOrderBean.class);
		query.setParameter("id", id);
		return query.uniqueResult();
	}
	
	public List<PlaceOrderBean> getAllPlaceOrder(){
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = "from PlaceOrder";
		Query<PlaceOrderBean>query = session.createQuery(hqlstr,PlaceOrderBean.class);
		List<PlaceOrderBean>resultList = query.getResultList();
		return resultList;
		
	}
	
	public boolean updatePlaceOrder(PlaceOrderBean plOrder) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(plOrder);
			System.out.println("更新成功");
			return true;
		}catch(NoResultException e) {
			System.out.println("更新失敗");
			return false;
		}
	}
}
