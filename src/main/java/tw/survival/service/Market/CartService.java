package tw.survival.service.Market;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Market.CartBean;
import tw.survival.model.Market.CartRepository;
import tw.survival.model.Market.ProductRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartDao;

	@Autowired
	private ProductRepository productDao;

	public CartBean insertCart(CartBean cart) {
		try {
			return cartDao.save(cart);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public CartBean fingByCartId(Integer cartId) {
		Optional<CartBean> optional = cartDao.findById(cartId);

		if (optional.isPresent()) {
			return optional.get();
		}
		System.out.println("沒找到id 為" + cartId + "的資料");
		return null;
	}
	
	public CartBean fingByPlayerId(Integer playerId) {
		Optional<CartBean> optional = cartDao.findByplayer(playerId);

		if (optional.isPresent()) {
			return optional.get();
		}
		System.out.println("沒找到id 為" + playerId + "的資料");
		return null;
	}

	public List<CartBean> findAll() {
		return cartDao.findAll();
	}

	
//	//用ID刪除
	public void deleteCartById(Integer id) {
		CartBean cb = fingByCartId(id);
		cb.setPlayer(null);
		cb.setProduct(null);
		cartDao.deleteById(id);
		return;
	}

	// 找全部購物車
		public List<CartBean> findAllCart() {
			return cartDao.findAll();
		}
	
	public boolean deleteByEntity(CartBean cart) {
		try {
			cartDao.delete(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteAll() {
		try {
			cartDao.deleteAll();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 將欲結帳的購物車實體 id 分別轉換成對應訂單實體，轉換完成後刪除該 id 的購物車實體
	 * 
	 * @param cart 裝著欲結帳的購物車實體 id 的 List 物件
	 * @return 結帳成功回傳 true，失敗回傳 false
	 * @author 張烜赫
	 */
	public boolean checkout(List<Integer> list) {
		try {
			// 將欲結帳的購物車實體 id 分別轉換成對應訂單實體
			// 轉換完成後刪除該 id 的購物車實體
			for (Integer id : list) {
				Optional<CartBean> optional = cartDao.findById(id);
				if (optional.isPresent()) {
					CartBean cart = optional.get();
					// 將購物車實體轉換成對應訂單實體
					cartDao.delete(cart);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	-------------------------------------------------------------------------------

//	public List<CartBean> listCartItems(PlayerBean player) {
//		return cartDao.findByplayer(player);
//	}
//
//	public Integer addProduct(Integer productId, Integer quantity, PlayerBean player) {
//		Integer addQuantity = quantity;
//		ProductBean product = productDao.findById(productId).get();
//		CartBean cart = cartDao.findByplayerAndProduct(player, product);
//		if (cart != null) {
//			addQuantity = cart.getQuantity() + quantity;
//			cart.setQuantity(addQuantity);
//		} else {
//			cart = new CartBean();
//			cart.setQuantity(quantity);
//			cart.setPlayer(player);
//			cart.setProduct(product);
//		}
//		cartDao.save(cart);
//		return addQuantity;
//	}

}