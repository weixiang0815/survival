package tw.survival.model.User;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 新增一名使用者資料
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
	 * R
	 */
	
	/**
	 * D
	 */
	
	/**
	 * U
	 */

}