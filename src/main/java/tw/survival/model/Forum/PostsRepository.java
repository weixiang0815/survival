package tw.survival.model.Forum;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostsRepository extends JpaRepository<PostsBean, Integer> {
	//name屬性模糊搜尋
	@Query(value = "from PostsBean where name like %:name% order by added desc")
	public List<PostsBean> findPostsBeanLike(@Param("name") String name);

	@Query(value = "delete from posts where fk_competition_id = :id", countProjection = "posts", nativeQuery = true)
	public void deletePostsByCompetitionId(@Param("id") Integer id);
	
	//搜尋玩家編輯的所有貼文
	@Query(value="select * from [Survival].[dbo].[Posts] where fk_player_id = :id "
			+ " and classify = :classify order by added desc",
		       nativeQuery=true,
		       countProjection = "posts")
	public Page<PostsBean> findPostByPlayerId(@Param("id")Integer id, @Param("classify")String classify, Pageable pgb);
	
	//由id尋找單個貼文
	@Query(value = "from posts where fk_competition_id = :id", countProjection = "posts", nativeQuery = true)
	public List<PostsBean> findPostsByCompetitionId(@Param("id") Integer id);

	//依照貼文更新時間排序
	public List<PostsBean> findPostsBeanByOrderByFinalAddedDesc();

	//依照貼文創建時間排序
	public List<PostsBean> findPostsBeanByOrderByAddedDesc();
	
	//name屬性模糊搜尋，並已分頁顯示。
	public Page<PostsBean> findByNameContainingOrderByAddedDesc(String name, Pageable pageable);
	
}