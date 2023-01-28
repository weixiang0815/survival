package tw.survival.model.User;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDAO uDAO;

	public UserService() {
	}
	
	/**
	 * 新增一名使用者資料
	 * 
	 * @param user 欲新增的 UserBean
	 * 
	 * @return 回傳傳入的 UserBean
	 */
	public UserBean addUser(UserBean user) {
		return uDAO.addUser(user);
	}

	/**
	 * 透過 id 查詢一筆使用者資料
	 * 
	 * @param id 欲查詢資料的使用者 id
	 * 
	 * @return 回傳查到的 UserBean
	 */
	public UserBean getOneUserById(Integer id) {
		return uDAO.getOneUserById(id);
	}

	/**
	 * 透過 account 查詢一筆使用者資料
	 * 
	 * @param account 欲查詢資料的使用者 account
	 * 
	 * @return 回傳查到的 UserBean
	 */
	public UserBean getOneUserByAccount(String account) {
		return uDAO.getOneUserByAccount(account);
	}

	/**
	 * 查詢所有使用者資料
	 * 
	 * @return 回傳裝著所有 UserBean 的列表
	 */
	public List<UserBean> getAllUsers() {
		return uDAO.getAllUsers();
	}

	/**
	 * 檢查登入是否成功
	 * 
	 * @param user 欲檢查登入的 UserBean
	 * 
	 * @return 登入成功回傳 true，否則回傳 false
	 */
	public boolean checkLogin(UserBean user) {
		return uDAO.checkLogin(user);
	}

	/**
	 * delete 相關方法
	 */

	/**
	 * update 相關方法
	 */

}