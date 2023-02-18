package tw.survival.model.Competition;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewCompetitionFormRepository extends JpaRepository<NewCompetitionFormBean, Integer> {

	public NewCompetitionFormBean findByPlayerId(Integer playerId);

	public NewCompetitionFormBean findByEmployeeId(Integer employeeId);

	public NewCompetitionFormBean findFirstByOrderByLastEditedDesc();

}