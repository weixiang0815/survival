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
public class WarehouseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public WarehouseDAO() {
	}

	
	
	public WarehouseBean addWarehouse(WarehouseBean warehouse) {
		Session session = sessionFactory.getCurrentSession();
		
		if(warehouse != null) {
			session.save(warehouse);
		}
		return warehouse;
	}
	
	
	public WarehouseBean getOneWarehouseById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		String hqlstr = "from WarehouseBean where id = :id";
		
		Query<WarehouseBean> query = session.createQuery(hqlstr,WarehouseBean.class);
		query.setParameter("id", id);
		
		return query.uniqueResult();
		
	}
	
	public List<WarehouseBean> getAllWarehouse(){
		Session session = sessionFactory.getCurrentSession();
		
		String hqlstr = "from WarehouseBean";

		Query<WarehouseBean> query = session.createQuery(hqlstr, WarehouseBean.class);
	
		List<WarehouseBean> resultList = query.getResultList();
		
		return resultList;
	}
	
	
	public String deleteWarehouseById(Integer id){
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = "delete WarehouseBean where id = :id";
		int result = session.createQuery(hqlstr).setParameter("id", id).executeUpdate();
		return result > 0 ? "刪除成功🤪🤪🤪" : "刪除失敗😥😥😥";
		
	}
	
	public boolean updateWarehouse(WarehouseBean warehouse) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(warehouse);
			System.out.println("更新成功");
			return true;
		} catch (NoResultException e) {
			System.out.println("更新失敗");
			return false;
		}
	}
	
	
}
