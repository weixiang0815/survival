package tw.survival.model.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<PlayerBean, Integer> {

	@Query(value = "Select * from Player Where account=:account", nativeQuery = true)
	public PlayerBean findByAccount(@Param(value = "account") String account);

}