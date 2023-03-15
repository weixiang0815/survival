package tw.survival.service.Player;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.SignUpBean;
import tw.survival.model.Player.PlayerBean;
import tw.survival.model.Player.PlayerRepository;
import tw.survival.service.Competition.SignUpService;

@Service
@Transactional
public class PlayerService {

	@Autowired
	private PlayerRepository pDAO;

	@Autowired
	private SignUpService signupService;
	
	

	// C
	public PlayerBean addplayer(PlayerBean pBean) {
		return pDAO.save(pBean);
	}

	// R
	public PlayerBean findByBean(Integer id) {
		Optional<PlayerBean> option = pDAO.findById(id);
		if (option.isPresent()) {
			return option.get();
		}
		return null;
	}

	// U
	public PlayerBean update(PlayerBean pBean) {
		pDAO.save(pBean);
		return null;
	}

	// R
	public List<PlayerBean> findAll() {
		return pDAO.findAll();
	}

	// D
	public void delete(Integer id) {
		List<SignUpBean> signups = signupService.findByPlayerId(id);
		if (signups != null && signups.size() != 0) {
			for (SignUpBean signup : signups) {
				signupService.deleteByEntity(signup);
			}
		}
		pDAO.deleteById(id);
		return;
	}

	// Search name
	public List<PlayerBean> findName(String name) {
		return pDAO.searchByNameLike(name);
	}

	public void UpdateStatus(Integer id, Integer status) {
		pDAO.updateStatusById(id, status);
	}

	public PlayerBean findbyemail(String email) {
		return pDAO.findByemail(email);

	}
}