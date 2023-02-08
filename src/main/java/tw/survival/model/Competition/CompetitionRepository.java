package tw.survival.model.Competition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CompetitionRepository extends JpaRepository<CompetitionBean, Integer> {

}