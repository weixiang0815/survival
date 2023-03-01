package tw.survival.model.Competition;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CompetitionRepository extends JpaRepository<CompetitionBean, Integer> {

	public CompetitionBean findFirstByOrderByIdDesc();
	
	public List<CompetitionBean> findByStatus(@Param("status") String status);
	
	public List<Integer> findCompetitionIdByStatus(@Param("status") String status);

}