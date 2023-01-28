package tw.survival.model.User;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDAO uDAO;
	
	public UserBean addUser(UserBean user) {
		return uDAO.addUser(user);
	}
	
	public boolean checkLogin(UserBean user) {
		return false;
	}
	
}