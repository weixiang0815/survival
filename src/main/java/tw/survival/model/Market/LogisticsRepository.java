package tw.survival.model.Market;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LogisticsRepository extends JpaRepository<LogisticsBean, Integer> {

	@Query(value = "select * from Logistics where fk_orderitem_id = ?1", nativeQuery = true)
	public LogisticsBean findByOrderItemId(Integer id);

}