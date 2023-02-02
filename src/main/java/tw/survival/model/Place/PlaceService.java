package tw.survival.model.Place;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	public boolean deletePlaceByBean(PlaceBean place) {
		return pDAO.deletePlaceByBean(place);
	}
	
	public String deletePlaceById(Integer id) {
		return pDAO.deletePlaceById(id);
	}
	
	public boolean updatePlace(PlaceBean place) {
		return pDAO.updatePlace(place);
	}
}
