package tw.survival.model.Market;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.survival.model.Player.PlayerBean;


public interface CartRepository extends JpaRepository<CartBean, Integer> {
	
	public List<CartBean> findByplayer(PlayerBean player);
	
	public CartBean findByplayerAndProduct(PlayerBean player,ProductBean Product);

}