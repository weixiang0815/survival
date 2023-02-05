package tw.survival.service.Competition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.survival.model.Competition.SignUpBean;
import tw.survival.model.Competition.SignUpDAO;

@Service
@Transactional
public class SignUpService {

	@Autowired
	private SignUpDAO suDAO;

	public SignUpService() {
	}

	/**
	 * 新增一筆報名資料
	 * 
	 * @param signup 欲新增的 SignUpBean
	 * 
	 * @return 回傳傳入的 SignUpBean
	 */
	public SignUpBean addSignUp(SignUpBean signup) {
		return suDAO.addSignUp(signup);
	}

	/**
	 * 透過 SignUpBean 刪除一筆報名資料
	 * 
	 * @param signup 欲刪除資料的 SignUpBean
	 * 
	 * @return 刪除成功回傳 true，否則回傳 false
	 */
	public boolean deleteSignUpByBean(SignUpBean signup) {
		return suDAO.deleteSignUpByBean(signup);
	}

	/**
	 * 透過 id 刪除一筆報名資料
	 * 
	 * @param id 欲刪除資料的報名 id
	 * 
	 * @return 刪除成功回傳 true，否則回傳 false
	 */
	public String deleteSignUpById(Integer id) {
		return suDAO.deleteSignUpById(id);
	}

	/**
	 * 更新一筆報名資料
	 * 
	 * @param signup 傳入欲更新資料的報名 SignUpBean
	 * 
	 * @return 更新成功回傳 true，否則回傳 false
	 */
	public boolean updateSignUp(SignUpBean signup) {
		return suDAO.updateSignUp(signup);
	}

	/**
	 * 透過 id 查詢一筆報名資料
	 * 
	 * @param id 欲查詢資料的報名 id
	 * 
	 * @return 回傳查到的 SignUpBean
	 */
	public SignUpBean getOneSignUpById(Integer id) {
		return suDAO.getOneSignUpById(id);
	}

	/**
	 * 查詢所有報名資料
	 * 
	 * @return 回傳裝著所有 SignUpBean 的列表
	 */
	public List<SignUpBean> getAllSignUps() {
		return suDAO.getAllSignUps();
	}

}