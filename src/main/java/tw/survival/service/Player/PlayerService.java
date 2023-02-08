package tw.survival.service.Player;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Player.PlayerRepository;

@Service
@Transactional
public class PlayerService {

	@Autowired
	private PlayerRepository pDAO;

} 