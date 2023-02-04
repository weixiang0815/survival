package tw.survival.model.Place;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class InventoryDAO {

	private SessionFactory sessionFactory;
	
	public InventoryDAO() {

	}

	public InventoryBean addInventory(InventoryBean inventory) {
		Session session = sessionFactory.getCurrentSession();
		if(inventory != null) {
			session.save(inventory);
		}
		return inventory;
	}
	
	public InventoryBean getInventoryById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = "from InventoryBean where id =:id";
		Query<InventoryBean>query = session.createQuery(hqlstr, InventoryBean.class);
	    query.setParameter("id", id);
	    return query.uniqueResult();
	    		
	}
	
	public List<InventoryBean> getAllInventory(){
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = "from InventoryBean";
		Query<InventoryBean>query = session.createQuery(hqlstr, InventoryBean.class);
        List<InventoryBean> resultList = query.getResultList();
        return resultList;
	}
	
	public String deleteInventoryById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = "delete InventoryBean where id = :id";
		int result = session.createQuery(hqlstr).setParameter("id", id).executeUpdate();
		return result > 0 ? "刪除成功🤪🤪🤪" : "刪除失敗😥😥😥";

	}
	
	public boolean updateInventory(InventoryBean inventory) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(inventory);
			System.out.println("更新成功");
			return true;
		} catch (NoResultException e) {
			System.out.println("更新失敗");
			return false;
		}
	}
	
	
	
	
}
