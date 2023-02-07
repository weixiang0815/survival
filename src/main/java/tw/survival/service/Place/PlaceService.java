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
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	
	public List<PlaceBean>getAllPlace(){
		return pDAO.findAll();
	}

	
	public void deletePlaceById(Integer id) {
		 pDAO.deleteById(id);
	}
	
	public PlaceBean updatePlace(PlaceBean place) {
		return pDAO.save(place);
	}
}
