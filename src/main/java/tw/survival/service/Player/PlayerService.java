package tw.survival.service.Player;

import java.util.List;
import java.util.Optional;

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
	
	//C
	public void addplayer(PlayerBean pBean) {
		pDAO.save(pBean);
	}
	//R
	public PlayerBean findByBean(Integer id) {
		Optional<PlayerBean> option=pDAO.findById(id);
		if(option.isPresent()) {
			return option.get();
		}
		return null;
	}
	//U
	public PlayerBean update(PlayerBean pBean) {
		 pDAO.save(pBean);
		 return null;
	}
	
	//R
	public List<PlayerBean> findAll() {
		 return pDAO.findAll();
	}
	//D
	public void delete(Integer id) {
		pDAO.deleteById(id);
		return;
	}
	//Search name
	public List<PlayerBean> findName(String name){
		return pDAO.searchByNameLike(name);
	}
		 
}