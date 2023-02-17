package tw.survival.model.Forum;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



public interface BookmarkletRepository extends JpaRepository<BookmarkletBean, Integer> {
	
//	@Transactional
//	@Modifying
//	@Query(value = "delete from bookmarklet where fk_player_id = :id",nativeQuery = true)
//	public void deletePlayerMark(@Param("id")Integer id);
//	
//	@Transactional
//	@Modifying
//	@Query(value = "delete from bookmarklet where fk_posts_id = :id",nativeQuery = true)
//	public void deletePostMark(@Param("id") Integer id);
//	
//	@Transactional
//	@Modifying
//	@Query(value = "delete from bookmarklet where fk_posts_id = :post and fk_player_id = :player",nativeQuery = true)
//	public void PlayerDeleteOnePostMark(@Param("post") Integer postId, @Param("player") Integer playerId);
	
	@Query(value = "select * from bookmarklet where fk_posts_id = :id",nativeQuery = true)
	public List<BookmarkletBean> findCustomerByNameNativeQuery(@Param("id") Integer id);
	
	
	
}
