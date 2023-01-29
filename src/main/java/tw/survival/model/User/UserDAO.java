package tw.survival.model.User;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAO() {
	}
	
	/**
	 * 新增一名使用者資料
	 * 
	 * @param user 欲新增的 UserBean
	 * 
	 * @return 回傳傳入的 UserBean
	 */
	public UserBean addUser(UserBean user) {
		Session session = sessionFactory.openSession();
		if (user != null) {
			session.save(user);
		}
		session.close();
		return user;
	}

	/**
	 * 透過 id 查詢一筆使用者資料
	 * 
	 * @param id 欲查詢資料的使用者 id
	 * 
	 * @return 回傳查到的 UserBean
	 */
	public UserBean getOneUserById(Integer id) {
		Session session = sessionFactory.openSession();

		String hqlstr = "from UserBean where id = :id";
		Query<UserBean> query = session.createQuery(hqlstr, UserBean.class);
		query.setParameter("id", id);

		return query.uniqueResult();
	}

	/**
	 * 透過 account 查詢一筆使用者資料
	 * 
	 * @param account 欲查詢資料的使用者 account
	 * 
	 * @return 回傳查到的 UserBean
	 */
	public UserBean getOneUserByAccount(String account) {
		Session session = sessionFactory.openSession();

		String hqlstr = "from UserBean where account = :account";
		Query<UserBean> query = session.createQuery(hqlstr, UserBean.class);
		query.setParameter("account", account);

		return query.uniqueResult();
	}
	
	/**
	 * 查詢所有使用者資料
	 * 
	 * @return 回傳裝著所有 UserBean 的列表
	 */
	public List<UserBean> getAllUsers() {
		Session session = sessionFactory.openSession();

		String hqlstr = "from UserBean";
		Query<UserBean> query = session.createQuery(hqlstr, UserBean.class);

		return query.getResultList();
	}

	/**
	 * 檢查登入是否成功
	 * 
	 * @param user 欲檢查登入的 UserBean
	 * 
	 * @return 登入成功回傳 true，否則回傳 false
	 */
	public boolean checkLogin(UserBean user) {
		Session session = sessionFactory.openSession();

		String hqlstr = "from UserBean where account = :account and password = :password";
		Query<UserBean> query = session.createQuery(hqlstr, UserBean.class);
		query.setParameter("account", user.getAccount());
		query.setParameter("password", user.getPassword());

		UserBean account = query.uniqueResult();

		return account != null;
	}

	/**
	 * 檢查登入是否成功
	 * 
	 * @param user 欲檢查刪除的 UserBean
	 * 
	 * @return 登入成功回傳 true，否則回傳 false
	 */
	public boolean deleteUser(UserBean user) {
		Session session = sessionFactory.openSession();

		
		if (user != null) {
			session.delete(user);
		    System.out.println("is delete.");
		    
		    return true;
		}

		return false;
	}
	
	/**
	 * 檢查登入是否成功
	 * 
	 * @param  id  欲刪除的user ID
	 * 
	 * @return 登入成功回傳 true，否則回傳 false
	 */
	public boolean deleteUserById(int id) {
		Session session = sessionFactory.openSession();

		
		Query<UserBean> query = session.createQuery("delete UserBean where id = :id",UserBean.class);
		query.setParameter("id", id);
		 
		int result = query.executeUpdate();
		 
		if (result > 0) {
		    System.out.println("Expensive products was removed");
		    return true;
		}

		return false;
	}
	
	
	/**
	 * 檢查登入是否成功
	 * 
	 * @param  account  欲刪除的user ID
	 * 
	 * @return 登入成功回傳 true，否則回傳 false
	 */
	public boolean deleteUserByAccount(String account) {
		Session session = sessionFactory.openSession();

		
		Query<UserBean> query = session.createQuery("delete UserBean where account = :account",UserBean.class);
		query.setParameter("account", account);
		 
		int result = query.executeUpdate();
		 
		if (result > 0) {
		    System.out.println("Expensive products was removed");
		    return true;
		}

		return false;
	}
//	Query query = session.createQuery("delete Product where price > :maxPrice");
//	query.setParameter("maxPrice", new Float(1000f));
//	 
//	int result = query.executeUpdate();
//	 
//	if (result > 0) {
//	    System.out.println("Expensive products was removed");
//	}
	/**
	 * update 相關方法
	 */

}