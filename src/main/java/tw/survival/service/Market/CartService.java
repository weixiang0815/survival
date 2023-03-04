package tw.survival.service.Market;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Market.CartBean;
import tw.survival.model.Market.CartRepository;
import tw.survival.model.Market.ProductBean;

@Service
public class CartService {

	@Autowired
	private CartRepository CartDao;

	public CartBean insertCart(CartBean cart) {
		try {
			return CartDao.save(cart);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public CartBean fingByCartId(Integer cartId) {
		Optional<CartBean> optional = CartDao.findById(cartId);

		if (optional.isPresent()) {
			return optional.get();
		}
		System.out.println("沒找到id 為" + cartId + "的資料");
		return null;
	}

	public List<CartBean> findAll() {
		return CartDao.findAll();
	}

	public boolean deleteById(Integer id) {
		try {
			CartDao.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteByEntity(CartBean cart) {
		try {
			CartDao.delete(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteAll() {
		try {
			CartDao.deleteAll();
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
				Optional<CartBean> optional = CartDao.findById(id);
				if (optional.isPresent()) {
					CartBean cart = optional.get();
					// 將購物車實體轉換成對應訂單實體
					CartDao.delete(cart);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}