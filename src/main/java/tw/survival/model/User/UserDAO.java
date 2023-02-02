package tw.survival.model.User;

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
		Session session = sessionFactory.getCurrentSession();
		if (user != null) {
			session.save(user);
			System.out.println("length:"+user.getThumbnail().length);
		}
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
		Session session = sessionFactory.getCurrentSession();

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
		Session session = sessionFactory.getCurrentSession();

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
		Session session = sessionFactory.getCurrentSession();

		String hqlstr = "from UserBean";
		Query<UserBean> query = session.createQuery(hqlstr, UserBean.class);
		List<UserBean> resultList = query.getResultList();
		return resultList;
	}

	/**
	 * 檢查登入是否成功
	 * 
	 * @param user 欲檢查登入的 UserBean
	 * 
	 * @return 登入成功回傳 true，否則回傳 false
	 */
	public boolean checkLogin(UserBean user) {
		Session session = sessionFactory.getCurrentSession();

		String hqlstr = "from UserBean where account = :account and password = :password";
		Query<UserBean> query = session.createQuery(hqlstr, UserBean.class);
		query.setParameter("account", user.getAccount());
		query.setParameter("password", user.getPassword());

		UserBean account = query.uniqueResult();

		return account != null;
	}

	/**
	 * 透過 UserBean 刪除一筆使用者資料
	 * 
	 * @param user 欲刪除資料的 UserBean
	 * 
	 * @return 刪除成功回傳 true，否則回傳 false
	 */
	public boolean deleteUserByBean(UserBean user) {
		Session session = sessionFactory.getCurrentSession();

		if (user != null) {
			session.delete(user);
			System.out.println("User deleted.");

			return true;
		}

		return false;
	}

	/**
	 * 透過 id 刪除一筆使用者資料
	 * 
	 * @param id 欲刪除資料的使用者 id
	 * 
	 * @return 刪除成功回傳 true，否則回傳 false
	 */
	public String deleteUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = "delete UserBean where id = :id";
		int result = session.createQuery(hqlstr).setParameter("id", id).executeUpdate();
		return result > 0 ? "刪除成功🤪🤪🤪" : "刪除失敗😥😥😥";
	}

	/**
	 * 透過 account 刪除一筆使用者資料
	 * 
	 * @param account 欲刪除資料的使用者 account
	 * 
	 * @return 刪除成功回傳 true，否則回傳 false
	 */
	public boolean deleteUserByAccount(String account) {
		Session session = sessionFactory.getCurrentSession();

		String hqlstr = "delete UserBean where account = :account";
		Query<UserBean> query = session.createQuery(hqlstr, UserBean.class);
		query.setParameter("account", account);

		int result = query.executeUpdate();

		if (result > 0) {
			System.out.println("User deleted.");
			return true;
		}

		return false;
	}

	/**
	 * 更新一筆使用者資料
	 * 
	 * @param user 傳入欲更新資料的使用者 UserBean
	 * 
	 * @return 更新成功回傳 true，否則回傳 false
	 */
	public boolean updateUser(UserBean user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(user);
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}

	public UserBean insert(UserBean u) {
		/**
		 * 新增圖片
		 * 
		 * @param thumbnail 欲新增的 UserBean
		 * 
		 * @return 回傳傳入的 UserBean
		 */
		
		Session session = sessionFactory.getCurrentSession();
		if (u != null) {
			session.save(u);
		}
		session.close();
		return u;
	}

	

}
