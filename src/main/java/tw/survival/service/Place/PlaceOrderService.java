package tw.survival.service.Place;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Place.PlaceOrderBean;
import tw.survival.model.Place.PlaceOrderDAO;

@Service
@Transactional
public class PlaceOrderService {

	@Autowired
	private PlaceOrderDAO plodrDAO;
	
	
	public PlaceOrderService() {
	
	}

	
	public PlaceOrderBean addPlaceOrder(PlaceOrderBean placeOrder) {
		return plodrDAO.addPlaceOrder(placeOrder);
	}
	
	public PlaceOrderBean getOnePlaceOrderById(Integer id) {
		return plodrDAO.getOnePlaceOrderById(id);
	}
	
	public List<PlaceOrderBean> getAllPlaceOrder(){
		return plodrDAO.getAllPlaceOrder();
	}
	
	public String deletePlaceOrderById(Integer id) {
		return plodrDAO.deletePlaceOrderById(id);
	}
	
	public boolean deletePlaceOrderByBean(PlaceOrderBean placeOrder) {
		return plodrDAO.deletePlaceOrderByBean(placeOrder);
	}
	
	public boolean updatePlaceOrder(PlaceOrderBean placeOrder) {
		return plodrDAO.updatePlaceOrder(placeOrder);
	}
	
	
}
