package tw.suvival.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountDAO aDao;
	
	public boolean checkLogin(Account user) {
		return aDao.checkLogin(user);
	}
	
}