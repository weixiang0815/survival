package tw.survival.model.Competition;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SignUpRepository extends JpaRepository<SignUpBean, Integer> {

	public List<SignUpBean> findByCompetition(Integer id);
	
	@Modifying
	@Query(value = "delete from SignUp where fk_competition_id = :id", nativeQuery = true, countProjection = "SignUp")
	public void deleteByCompetition(@Param("id") Integer id);
	
}