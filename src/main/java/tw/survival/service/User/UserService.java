package tw.survival.service.User;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.User.UserBean;
import tw.survival.model.User.UserDAO;

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
	 * 透過 UserBean 刪除一筆使用者資料
	 * 
	 * @param user 欲刪除資料的 UserBean
	 * 
	 * @return 刪除成功回傳 true，否則回傳 false
	 */
	public boolean deleteUserByBean(UserBean user) {
		return uDAO.deleteUserByBean(user);
	}

	/**
	 * 透過 id 刪除一筆使用者資料
	 * 
	 * @param id 欲刪除資料的使用者 id
	 * 
	 * @return 刪除成功回傳 true，否則回傳 false
	 */
	public String deleteUserById(int id) {
		return uDAO.deleteUserById(id);
	}

	/**
	 * 透過 account 刪除一筆使用者資料
	 * 
	 * @param account 欲刪除資料的使用者 account
	 * 
	 * @return 刪除成功回傳 true，否則回傳 false
	 */
	public boolean deleteUserByAccount(String account) {
		return uDAO.deleteUserByAccount(account);
	}

	/**
	 * 更新一筆使用者資料
	 * 
	 * @param user 傳入欲更新資料的使用者 UserBean
	 * 
	 * @return 更新成功回傳 true，否則回傳 false
	 */
	public boolean updateUser(UserBean user) {
		return uDAO.updateUser(user);
	}
	
	/**
	 * 新增一張圖片
	 * 
	 * @param userBean 傳入使用者圖片 UserBean
	 * 
	 * @return 不是空值就新增一張圖片
	 */
	public UserBean insert (UserBean u) {
		return uDAO.insert(u);
	}
} 