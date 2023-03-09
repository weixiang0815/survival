package tw.survival.model.Market;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderItemRepository extends JpaRepository<OrderItemBean, Integer> {
	@Query(value = "from OrderItemBean where fk_player_id like %:fk_player_id%")
	public List<OrderItemBean> findOrderItemidLike(@Param("fk_player_id") Integer fk_player_id);
}