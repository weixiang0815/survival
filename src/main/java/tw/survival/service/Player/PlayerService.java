package tw.survival.service.Player;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Player.PlayerBean;
import tw.survival.model.Player.PlayerRepository;

@Service
@Transactional
public class PlayerService {

	@Autowired
	private PlayerRepository pDAO;
public PlayerBean addplayer(String name,String account,String password,Integer age,String region,
		String address,Integer salary,String sex,String identity_number,String email,Date birthday
		,Date join_date,String phone) {
	
	
	return null;
}
} 