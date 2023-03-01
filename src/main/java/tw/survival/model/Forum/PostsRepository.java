package tw.survival.model.Forum;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;





public interface PostsRepository extends JpaRepository<PostsBean, Integer> {
	
	@Query(value = "from PostsBean where name like %:name% order by added desc")
	public List<PostsBean> findPostsBeanLike(@Param("name") String name);
	
	@Query(value = "delete from posts where fk_competition_id = :id", countProjection = "posts", nativeQuery = true)
	public void deletePostsByCompetitionId(@Param("id") Integer id);
	
	@Query(value = "form posts where fk_competition_id = :id", countProjection = "posts", nativeQuery = true)
	public List<PostsBean> findPostsByCompetitionId(@Param("id") Integer id);

	public List<PostsBean> findPostsBeanByOrderByFinalAddedDesc();
	
	public List<PostsBean> findPostsBeanByOrderByAddedDesc();
	
	
}
