package tw.survival.service.Place;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Place.PlaceBean;
import tw.survival.model.Place.PlaceDAO;

@Service
@Transactional
public class PlaceService {

	@Autowired
	private PlaceDAO pDAO;
	
	public PlaceService() {
		
	}
	
	
	public PlaceBean addPlace(PlaceBean place) {
		return pDAO.addPlace(place);
	}
	
	
	public PlaceBean getOnePlaceById(Integer id) {
		return pDAO.getOnePlaceById(id);
	}
	
	
	public PlaceBean getOnePlaceByName(String place_name) {
		return pDAO.getOnePlaceByName(place_name);
	}
	
	public List<PlaceBean>getAllPlace(){
		return pDAO.getAllPlace();
	}

	
	public String deletePlaceById(Integer id) {
		return pDAO.deletePlaceById(id);
	}
	
	public boolean updatePlace(PlaceBean place) {
		return pDAO.updatePlace(place);
	}
}
