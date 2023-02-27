package tw.survival.service.Forum;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Forum.PostsBean;
import tw.survival.model.Forum.PostsRepository;

@Service
public class PostsService {

	
	@Autowired
	private PostsRepository pDao;
	
	/**
	 * 新建一筆貼文資料
	 * 
	 * @param post 欲新建資訊的貼文實體，尚未連結活動內容
	 * @return 新建成功回傳貼文實體，失敗回傳 null
	 * @author 鄭力豪
	 */
	public PostsBean insertPost(PostsBean post) {
		try {
			return pDao.save(post);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 找到一筆該id紀錄的那筆貼文資料
	 * 
	 * @param id 欲查詢的貼文id
	 * @return 成功回傳PostsBean，失敗回傳Null
	 * @author 鄭力豪
	 */
	public PostsBean findPostById(Integer id) {
		if(pDao.existsById(id)) {
			return pDao.findById(id).get();
		}else {
			return null;
		}
	}
	
	
	/**
	 * 刪除一筆該id紀錄的那筆貼文資料
	 * 
	 * @param id 欲刪除的貼文id
	 * @return 成功回傳True，失敗回傳False
	 * @author 鄭力豪
	 */
	public boolean deletePost(Integer id) {
		if(pDao.existsById(id)) {
			pDao.deleteById(id);
			System.out.println("刪除成功。");
			return true;
		}
		System.out.println("未找到該ID:" + id);
		return false;
	} 
	
	/**
	 * 修改一筆貼文
	 * 
	 * @param post 欲新建資訊的貼文實體
	 * @return 修改成功回傳貼文實體，失敗回傳 null
	 * @author 鄭力豪
	 */
	public PostsBean updatePost(PostsBean post) {
		Optional<PostsBean> optional = pDao.findById(post.getId());
		if (optional.isPresent()) {
			return pDao.save(post);
		}
		return null;
	}
	
	/**
	 * 得到所有貼文資料，依照貼文新增的初始時間排序
	 * 
	 * 
	 * @return 一個PostsBean型別的List集合物件，或者null
	 * @author 鄭力豪
	 */
	public List<PostsBean> getAllPosts1(){
		return pDao.findPostsBeanByOrderByAddedDesc();
	}
	
	/**
	 * 得到所有貼文資料，依照貼文最近一次的更新時間排序
	 * 
	 * 
	 * @return 一個PostsBean型別的List集合物件，或者null
	 * @author 鄭力豪
	 */
	public List<PostsBean> getAllPosts2(){
		return pDao.findPostsBeanByOrderByFinalAddedDesc();
	}
	
	/**
	 * 得到所有該活動相關的貼文資料，依照貼文最近一次的更新時間排序
	 * 
	 * 
	 * @return 一個PostsBean型別的List集合物件，或者null
	 * @author 鄭力豪
	 */
	public List<PostsBean> getPostsByCpttId(Integer id){
		return pDao.findPostsByCompetitionId(id);
	}
	
	/**
	 * 刪除所有該活動相關的貼文資料
	 * 
	 * 
	 * @return
	 * @author 鄭力豪
	 */
	public void deletePostsByCpttId(Integer id){
		pDao.deletePostsByCompetitionId(id);
		return;
	}
	
	
	
	
}
