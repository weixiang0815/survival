package tw.survival.service.login_logout;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Employee.EmployeeBean;
import tw.survival.model.Employee.EmployeeReposity;
import tw.survival.model.Player.PlayerBean;
import tw.survival.model.Player.PlayerRepository;

@Service
@Transactional
public class login_logoutService {

	@Autowired
	public PlayerRepository pRepository;
	@Autowired 
	public EmployeeReposity empRepository;

	public PlayerBean login(String account, String password) {
		PlayerBean player = pRepository.findByAccount(account,password);
		if (player == null) {
			return null;
		}
		return player;
	}
	public EmployeeBean loginEmp(String account,String password) {
		EmployeeBean emp=empRepository.findByAccount(account,password);
		if(emp ==null) {
			return null;
		}
		return emp;
		
	}

}
