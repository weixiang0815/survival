package tw.survival.service.Forum;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tw.survival.model.Forum.MsgsBean;
import tw.survival.model.Forum.MsgsRepository;


@Service
public class MsgsService {

	@Autowired
	private MsgsRepository mDao;
	
	/**
	 * 
	 * @param msgs 欲新建資訊的留言實體，尚未連結貼文
	 * @return 新建成功回傳留言實體，失敗回傳 null
	 * @author 鄭力豪
	 * @apiNote 新建一筆留言資料
	 */
	public MsgsBean insertMsgs(MsgsBean msgs) {
		return mDao.save(msgs);
	}
	
	/**
	 * 
	 * @param id 欲查詢的留言id
	 * @return 成功回傳PostsBean，失敗回傳Null
	 * @author 鄭力豪
	 * @apiNote 找到一筆該id紀錄的那筆留言資料
	 */
	public MsgsBean findMsgsById(Integer id) {
		if (mDao.existsById(id)) {
			return mDao.findById(id).get();
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param id 欲刪除的留言id
	 * @return 成功回傳True，失敗回傳False
	 * @author 鄭力豪
	 * @apiNote 刪除一筆該id紀錄的那筆留言資料
	 */
	public boolean deleteMsgsById(Integer id) {
		Optional<MsgsBean> findById = mDao.findById(id);
		if (!findById.isEmpty()) {
			
			mDao.deleteById(id);
			return true;
			
		}
		return false;
	}
	
	/**
	 * 修改一筆留言
	 * 
	 * @param msgs 欲新建資訊的留言實體
	 * @return 修改成功回傳留言實體，失敗回傳 null
	 * @author 鄭力豪
	 */
	public MsgsBean updateMsgs(MsgsBean msgs) {
		Optional<MsgsBean> optional = mDao.findById(msgs.getId());
		if (optional.isPresent()) {
			msgs.setFinalAdded(new Date());
			return mDao.save(msgs);
		}
		return null;
	}
	
	/**
	 * 修改一筆留言
	 * 
	 * @param id 留言ID
	 * @param msgText 欲修改字串
	 * @return 修改成功回傳留言實體，失敗回傳 null
	 * @author 鄭力豪
	 */
	public MsgsBean updateMsgs(Integer id, String msgText) {
		Optional<MsgsBean> optional = mDao.findById(id);
		if (optional.isPresent()) {
			MsgsBean msgs = optional.get();
			msgs.setEssay(msgText);
			msgs.setFinalAdded(new Date());
			return mDao.save(msgs);
		}
		return null;
	}
	
	/**
	 * @param postId 貼文的Id
	 * @param pageNumber 頁碼
	 * @return 回傳Page物件，Page內容為多個MsgsBean物件
	 * @apiNote 得到該貼文的所有留言
	 * @author 鄭力豪
	 */
	public Page<MsgsBean> getAllMsgsOfPost(Integer pageNumber, Integer postId){
		Pageable pgb = PageRequest.of(pageNumber-1, 10,Sort.Direction.DESC, "added");
		Page<MsgsBean> page = mDao.findMsgsByPostId(postId, pgb);
		return page;
	}
	
	/**
	 * 
	 * @param playerId 玩家Id
	 * @apiNote 刪除該玩家所有的留言資料，玩家註銷用
	 * @author 鄭力豪
	 */
	public void deleteMsgsOfPlayer(Integer playerId) {
		mDao.deleteAllMsgsOfOnePlayer(playerId);
		return;
	}
	
	
	public List<MsgsBean> getMsgListOfPost(Integer postId){
		List<MsgsBean> list = mDao.findMsgsListByPostId(postId);
		return list;
	}
	
	
	
	
	
	
	
}
