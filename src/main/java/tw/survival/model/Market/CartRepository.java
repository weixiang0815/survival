package tw.survival.model.Market;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.survival.model.Player.PlayerBean;


public interface CartRepository extends JpaRepository<CartBean, Integer> {
	
	public Optional<CartBean> findByplayer(Integer player);
	
	public CartBean findByplayerAndProduct(PlayerBean player,ProductBean Product);

}