package tw.survival.model.Forum;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;





public interface PostsRepository extends JpaRepository<PostsBean, Integer> {
	
	@Query(value = "from PostsBean where name like %:name% order by added desc")
	public List<PostsBean> findPostsBeanLike(@Param("name") String name);
	


	public List<PostsBean> findPostsBeanOrderByFinalAddedDesc();
	
	public List<PostsBean> findPostsBeanOrderByAddedDesc();
	
	
}
