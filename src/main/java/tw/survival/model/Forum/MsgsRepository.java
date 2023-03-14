package tw.survival.model.Forum;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MsgsRepository extends JpaRepository<MsgsBean, Integer> {
	
	//得到該貼文的所有留言，並依照留言生成時間排序
	@Query(value="select * from [Survival].[dbo].[Msgs] where fk_posts_id = :id",
		       nativeQuery=true,
		       countProjection = "msgs")
	public Page<MsgsBean> findMsgsByPostId(@Param("id")Integer postId, Pageable pageable);
	
	//刪除某玩家所有留言
	@Modifying
	@Query(value="delete from msgs where fk_player_id = ?1", nativeQuery=true, countProjection = "msgs")
	public void deleteAllMsgsOfOnePlayer(Integer playerId); 
	
}