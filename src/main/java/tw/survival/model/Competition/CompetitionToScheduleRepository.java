package tw.survival.model.Competition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompetitionToScheduleRepository extends JpaRepository<CompetitionToScheduleBean, Integer> {

//	@Modifying
//	@Query(value = "delete from Competition_To_Schedule where fk_competition_id = :id", nativeQuery = true)
//	public void deleteByCompetitionId(@Param("id") Integer id);

}