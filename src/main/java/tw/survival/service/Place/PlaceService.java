package tw.survival.service.Place;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Place.PlaceBean;
import tw.survival.model.Place.PlaceRepository;

@Service
@Transactional
public class PlaceService {

	@Autowired
	private PlaceRepository pDAO;

	public PlaceService() {

	}

	public PlaceBean insertPlace(PlaceBean place) {
		return pDAO.save(place);
	}

	public PlaceBean getOnePlaceById(Integer id) {
		Optional<PlaceBean> optional = pDAO.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<PlaceBean> getAllPlace() {
		return pDAO.findAll();
	}

	public void deletePlaceById(Integer id) {

		PlaceBean place = getOnePlaceById(id);
		place.setProduct(null);
		pDAO.deleteById(id);
		return;
	}

	public PlaceBean updatePlaceById(Integer id, String placeName, String placeAddress, byte[] placePhoto,
			Integer placeFee, Integer placeCapacity) {
		Optional<PlaceBean> optional = pDAO.findById(id);

		if (optional.isPresent()) {
			PlaceBean pb = optional.get();
			pb.setPlace_name(placeName);
			pb.setPlace_address(placeAddress);
			pb.setPlace_photo(placePhoto);
			pb.setPlace_fee(placeFee);
			pb.setPlace_capacity(placeCapacity);
			return pb;
		}
		System.out.println("沒有這筆資料");
		return null;

	}
}
