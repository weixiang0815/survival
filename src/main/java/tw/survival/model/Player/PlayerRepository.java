package tw.survival.model.Player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<PlayerBean, Integer> {

	@Query(value = "Select * from Player Where account=:account and password=:password", nativeQuery = true)
	public PlayerBean findByAccount(@Param(value = "account") String account,
			@Param(value = "password") String password);

	@Query(value = "from PlayerBean where name like %:name%")
	public List<PlayerBean> searchByNameLike(@Param("name") String name);

	@Query(value="Select * from Player where email=:email",nativeQuery = true)
	public PlayerBean findByemail(@Param(value="email") String email );
	
	@Modifying
	@Query("UPDATE PlayerBean p SET p.status = :newStatus WHERE p.id = :id")
	void updateStatusById(@Param("id") Integer id, @Param("newStatus") Integer newStatus);
	
	
}