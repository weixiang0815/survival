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
public class SignUpDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 新增一筆報名資料
	 * 
	 * @param signup 欲新增的 SignUpBean
	 * 
	 * @return 回傳傳入的 SignUpBean
	 */
	public SignUpBean addSignUp(SignUpBean signup) {
		Session session = sessionFactory.getCurrentSession();
		if (signup != null) {
			session.save(signup);
		}
		return signup;
	}

	/**
	 * 透過 SignUpBean 刪除一筆報名資料
	 * 
	 * @param signup 欲刪除資料的 SignUpBean
	 * 
	 * @return 刪除成功回傳 true，否則回傳 false
	 */
	public boolean deleteSignUpByBean(SignUpBean signup) {
		Session session = sessionFactory.getCurrentSession();

		if (signup != null) {
			session.delete(signup);
			System.out.println("SignUp deleted.");

			return true;
		}

		return false;
	}

	/**
	 * 透過 id 刪除一筆報名資料
	 * 
	 * @param id 欲刪除資料的報名 id
	 * 
	 * @return 刪除成功回傳 true，否則回傳 false
	 */
	public String deleteSignUpById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hqlstr = "delete SignUpBean where id = :id";
		int result = session.createQuery(hqlstr).setParameter("id", id).executeUpdate();
		return result > 0 ? "刪除成功🤪🤪🤪" : "刪除失敗😥😥😥";
	}

	/**
	 * 更新一筆報名資料
	 * 
	 * @param signup 傳入欲更新資料的報名 SignUpBean
	 * 
	 * @return 更新成功回傳 true，否則回傳 false
	 */
	public boolean updateSignUp(SignUpBean signup) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(signup);
			System.out.println("更新成功");
			return true;
		} catch (NoResultException e) {
			System.out.println("更新失敗");
			return false;
		}
	}

	/**
	 * 透過 id 查詢一筆報名資料
	 * 
	 * @param id 欲查詢資料的報名 id
	 * 
	 * @return 回傳查到的 SignUpBean
	 */
	public SignUpBean getOneSignUpById(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		String hqlstr = "from SignUpBean where id = :id";
		Query<SignUpBean> query = session.createQuery(hqlstr, SignUpBean.class);
		query.setParameter("id", id);

		return query.uniqueResult();
	}

	/**
	 * 查詢所有報名資料
	 * 
	 * @return 回傳裝著所有 SignUpBean 的列表
	 */
	public List<SignUpBean> getAllSignUps() {
		Session session = sessionFactory.getCurrentSession();

		String hqlstr = "from SignUpBean";
		Query<SignUpBean> query = session.createQuery(hqlstr, SignUpBean.class);
		List<SignUpBean> resultList = query.getResultList();

		return resultList;
	}

}