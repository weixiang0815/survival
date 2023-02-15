package tw.survival.service.Forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Forum.BookmarkletBean;
import tw.survival.model.Forum.BookmarkletRpository;
import tw.survival.model.Forum.PostsBean;
import tw.survival.model.Player.PlayerBean;

@Service
public class BookmarkletService {

	@Autowired
	private BookmarkletRpository bDao;
	
	public BookmarkletBean addBml(BookmarkletBean bookmarklet) {
		
		return bDao.save(bookmarklet);
		
	}
	
	public BookmarkletBean Like(PostsBean post, PlayerBean player) {
		
		BookmarkletBean bml = new BookmarkletBean();
		bml.setPlayer(player);
		bml.setPosts(post);
		return bDao.save(bml);
		
	}
	
	
	
	public void deleteBml(Integer id) {
		bDao.deleteById(id);
		return;
	}
	
//	deletePlayerMark
	public void deleteBmlOfPlayer(Integer id) {
		bDao.deletePlayerMark(id);
		return;
	}
	
	public void deleteBmlOfPost(Integer id) {
		bDao.deletePostMark(id);
		return;
	}
	
	public void dislike(Integer postId, Integer playerId) {
		bDao.PlayerDeleteOnePostMark(postId, playerId);
	}
	
	
	
	
	
	
	
	
}
