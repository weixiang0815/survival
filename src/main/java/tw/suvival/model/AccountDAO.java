package tw.suvival.model;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean checkLogin(Account users) {
		Session session = sessionFactory.openSession();

		String hqlstr = "from Account where username = :user and userpwd = :pwd";
		Query<Account> query = session.createQuery(hqlstr, Account.class);
		query.setParameter("user", users.getUsername());
		query.setParameter("pwd", users.getUserpwd());

		Account account = query.uniqueResult();

		return account != null;
	}
}