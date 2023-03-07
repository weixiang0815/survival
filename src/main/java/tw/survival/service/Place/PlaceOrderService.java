package tw.survival.service.Place;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Place.PlaceOrderBean;
import tw.survival.model.Place.PlaceOrderRepository;

@Service
@Transactional
public class PlaceOrderService {

	@Autowired
	private PlaceOrderRepository plodrDAO;

	public PlaceOrderService() {
	}

	public PlaceOrderBean insertPlaceOrder(PlaceOrderBean placeOrder) {
		return plodrDAO.save(placeOrder);
	}

	public PlaceOrderBean getOnePlaceOrderById(Integer id) {
		Optional<PlaceOrderBean> optional = plodrDAO.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<PlaceOrderBean> getAllPlaceOrder() {
		return plodrDAO.findAll();
	}

	public void deletePlaceOrderById(Integer id) {
		plodrDAO.deleteById(id);
	}

	public PlaceOrderBean updatePlaceOrder(PlaceOrderBean placeOrder) {
		return plodrDAO.save(placeOrder);
	}

}