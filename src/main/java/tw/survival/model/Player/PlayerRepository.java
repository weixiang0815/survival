package tw.survival.model.Player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<PlayerBean, Integer> {

	@Query(value = "Select * from Player Where account=?1 and password=?2", nativeQuery = true)
	public PlayerBean findByAccount(String account, String password);

	@Query(value = "from PlayerBean where name like %:name%")
	public List<PlayerBean> searchByNameLike(@Param("name") String name);

	@Query(value="Select * from Player where email=:email",nativeQuery = true)
	public PlayerBean findByemail(@Param(value="email") String email );
	
	@Modifying
	@Query("UPDATE PlayerBean p SET p.status = :newStatus WHERE p.id = :id")
	public void updateStatusById(@Param("id") Integer id, @Param("newStatus") Integer newStatus);
	
	
}