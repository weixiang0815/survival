package tw.survival.service.Competition;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Competition.CompetitionBean;
import tw.survival.model.Competition.CompetitionRepository;
import tw.survival.model.Forum.PostsBean;
import tw.survival.service.Forum.PostsService;

@Service
@Transactional
public class CompetitionService {

	@Autowired
	private CompetitionRepository compDao;

	@Autowired
	private PostsService postsService;

	/**
	 * 新建一筆活動資訊，但尚未公布與發新貼文
	 * 
	 * @param comp 欲新建資訊的活動實體
	 * @return 新建成功回傳活動實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionBean create(CompetitionBean comp) {
		try {
			return compDao.save(comp);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 正式發布一筆活動資訊，並發新貼文
	 * 
	 * @param id 欲發布資訊的活動 id
	 * @return 發布成功回傳活動實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionBean publishById(Integer id) {
		Optional<CompetitionBean> optional = compDao.findById(id);
		if (optional.isPresent()) {
			CompetitionBean comp = optional.get();
			comp.setStatus("已發布");
			PostsBean newPost = new PostsBean();
			newPost.setName(comp.getMandarinName());
			newPost.setClassify("活動競賽😎");
			newPost.setEssay(comp.getContent());
			postsService.insertPost(newPost);
			compDao.save(comp);
			return comp;
		}
		return null;
	}

	/**
	 * 透過 id 查詢一筆活動實體
	 * 
	 * @param id 欲查詢資訊的活動 id
	 * @return 查詢成功回傳該活動實體，查無資料回傳 null
	 * @author 王威翔
	 */
	public CompetitionBean findById(Integer id) {
		Optional<CompetitionBean> optional = compDao.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	/**
	 * 查詢最新活動實體
	 * 
	 * @return 查詢成功回傳該活動實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionBean findLatestCompetition() {
		try {
			return compDao.findFirstByOrderByIdDesc();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查詢至今所有創建過的活動實體
	 * 
	 * @return 裝有所有活動實體的 List 物件
	 * @author 王威翔
	 */
	public List<CompetitionBean> findAll() {
		return compDao.findAll();
	}

	/**
	 * 透過 id 刪除一筆活動紀錄
	 * 
	 * @param id 欲刪除紀錄的活動實體 id
	 * @return 刪除成功回傳 true，失敗回傳 false
	 * @author 王威翔
	 */
	public boolean deleteById(Integer id) {
		try {
			// 需先刪除對應活動獎品實體與論壇系統貼文
			compDao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 透過實體刪除一筆活動紀錄
	 * 
	 * @param comp 欲刪除紀錄的活動實體
	 * @return 刪除成功回傳 true，失敗回傳 false
	 */
	public boolean deleteByEntity(CompetitionBean comp) {
		try {
			compDao.delete(comp);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 透過 id 下架一筆活動資訊並刪除貼文，但尚未從資料庫中刪除整個紀錄
	 * 
	 * @param id 欲下架的活動實體 id
	 * @return 下架成功回傳該活動實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionBean takedownById(Integer id) {
		Optional<CompetitionBean> optional = compDao.findById(id);
		if (optional.isPresent()) {
			CompetitionBean comp = optional.get();
			comp.setStatus("未發布");
			// 需刪除論壇系統的對應貼文
			compDao.save(comp);
			return comp;
		}
		return null;
	}

	/**
	 * 更新一筆活動實體
	 * 
	 * @param comp 欲更新內容的活動實體
	 * @return 更新成功回傳該活動實體，拋出錯誤回傳 null
	 * @author 王威翔
	 */
	public CompetitionBean updateByEntity(CompetitionBean comp) {
		if (compDao.findById(comp.getId()).isPresent()) {
			try {
				return compDao.save(comp);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 重新發布一筆既有的活動實體
	 * 
	 * @param id 欲重新發布的活動實體 id
	 * @return 重新發布成功回傳該活動實體，失敗回傳 null
	 * @author 王威翔
	 */
	public CompetitionBean republishById(Integer id) {
		Optional<CompetitionBean> optional = compDao.findById(id);
		if (optional.isPresent()) {
			CompetitionBean comp = optional.get();
			comp.setStatus("已發布");
			// 重新發布貼文
			compDao.save(comp);
			return comp;
		}
		return null;
	}

}