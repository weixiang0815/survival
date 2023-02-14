package tw.survival.service.Forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Forum.PostsBean;
import tw.survival.model.Forum.PostsRepository;

@Service
public class PostsService {

	
	@Autowired
	private PostsRepository pDao;
	
	
	public PostsBean addPost(PostsBean post) {
		return pDao.save(post);
	}
	
	public void deletePost(Integer id) {
		if(pDao.existsById(id)) {
			pDao.deleteById(id);
			System.out.println("刪除成功。");
		}
		System.out.println("未找到該ID:" + id);
		return;
	} 
	
	public PostsBean updatePost(PostsBean post) {
		if(!pDao.existsById(post.getId())) {
			return null;
		}
		return pDao.save(post);
	}
	
	public List<PostsBean> getAll(){
		return pDao.findPostsBeanDesc();
	}
	
	
	
	
	
}
