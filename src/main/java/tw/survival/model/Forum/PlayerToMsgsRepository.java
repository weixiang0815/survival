package tw.survival.model.Forum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PlayerToMsgsRepository extends JpaRepository<PlayerToMsgsBean, Integer> {
	
	@Query(name="select * from [Survival].[dbo].[PlayerToMsgs] where fk_msgs_id = :id", countProjection = "PlayerToMsgs", nativeQuery = true )
	public PlayerToMsgsBean getPtmbByMsgsId(@Param("id")Integer id);

}
