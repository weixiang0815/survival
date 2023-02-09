package tw.survival.service.checklogin;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Player.PlayerBean;
import tw.survival.model.Player.PlayerRepository;

@Service
@Transactional
public class CheckloginService {

	@Autowired
	public PlayerRepository pDAO;
	
	public boolean Checklogin(PlayerBean bean,Session session) {
		
		return pDAO.CheckLogin(bean,session);
	}
}
