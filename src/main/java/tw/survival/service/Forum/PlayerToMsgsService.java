package tw.survival.service.Forum;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Forum.PlayerToMsgsBean;
import tw.survival.model.Forum.PlayerToMsgsRepository;

@Service
public class PlayerToMsgsService {

	@Autowired
	PlayerToMsgsRepository pDao;
	
	//C
	public PlayerToMsgsBean insertPtmb(PlayerToMsgsBean ptmb) {
		return pDao.save(ptmb);
	}
	
	//R
	public PlayerToMsgsBean findPtmbById(Integer id) {
		Optional<PlayerToMsgsBean> optional = pDao.findById(id);
		if(!optional.isEmpty()) {
			return optional.get();
		}
		return null;
	}
	//D
	public void deletePtmb(Integer id){
		Optional<PlayerToMsgsBean> optional = pDao.findById(id);
		if(!optional.isEmpty()) {
			pDao.deleteById(id);
		}else {
			System.out.println("找不到刪除資料。id="+id);
		}
		return;
	}
	//any special?   No!
}
