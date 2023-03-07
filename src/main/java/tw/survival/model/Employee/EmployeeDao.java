package tw.survival.model.Employee;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmployeeDao {

	@Autowired
	public SessionFactory sessionfactory;

	public EmployeeDao() {
	}

	/**
	 * 新增一名職員資料
	 * 
	 * @param user 欲新增的 EmployeeBean
	 * 
	 * @return 回傳傳入的 EmployeeBean
	 */
	public EmployeeBean addemp(EmployeeBean employee) {
		Session session = sessionfactory.getCurrentSession();
		if (employee != null) {
			session.save(employee);
		}
		return employee;
	}

	/**
	 * 透過 id 查詢一筆使用者資料
	 * 
	 * @param id 欲查詢資料的使用者 id
	 * 
	 * @return 回傳查到的 EmployeeBean
	 */

	public EmployeeBean findOneemp(Integer id) {
		Session session = sessionfactory.getCurrentSession();
		String sqlh = "from EmployeeBean where id = :id";
		Query<EmployeeBean> query = session.createQuery(sqlh, EmployeeBean.class);
		query.setParameter("id", id);

		return query.uniqueResult();
	}

	/**
	 * 查詢所有職員資料
	 * 
	 * @return 回傳裝著所有EmployeeBean 的列表
	 */

	public List<EmployeeBean> findAllemp() {
		Session session = sessionfactory.getCurrentSession();

		String hqlstr = "from EmployeeBean ";
		Query<EmployeeBean> query = session.createQuery(hqlstr, EmployeeBean.class);
		List<EmployeeBean> list = query.getResultList();

		return list;
	}

	public String deleteEmpId(Integer id) {
		Session session = sessionfactory.getCurrentSession();
		String hqlstr = "delete EmployeeBean where id = :id";
		int result = session.createQuery(hqlstr).setParameter("id", id).executeUpdate();

		return result > 0 ? "刪除成功🤪🤪🤪" : "刪除失敗😥😥😥";
	}

}