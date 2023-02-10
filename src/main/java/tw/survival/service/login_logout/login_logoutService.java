package tw.survival.service.login_logout;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Player.PlayerBean;
import tw.survival.model.Player.PlayerRepository;

@Service
@Transactional
public class login_logoutService {

	@Autowired
	public PlayerRepository pRepository;

	public PlayerBean login(String account, String password) {
		PlayerBean player = pRepository.findByAccount(account);
		if (player == null) {
			return null;
		}
		return player;
	}	

}
