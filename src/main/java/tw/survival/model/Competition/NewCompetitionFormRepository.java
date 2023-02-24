package tw.survival.model.Competition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NewCompetitionFormRepository extends JpaRepository<NewCompetitionFormBean, Integer> {

	@Query(value = "from NewCompetitionFormBean where creatorId = :creatorId and creatorType = :creatorType")
	public NewCompetitionFormBean findByCreator(@Param("creatorId") Integer creatorId,
			@Param("creatorType") Integer CreatorType);

	public NewCompetitionFormBean findFirstByOrderByLastEditedDesc();

}