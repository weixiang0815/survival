package tw.survival.service.Place;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Place.WarehouseBean;
import tw.survival.model.Place.WarehouseRepository;

@Service
@Transactional
public class WarehouseService {
	
	@Autowired
	private WarehouseRepository wDAO;
	

	public WarehouseService() {
	}

	
	public WarehouseBean insertWarehouse(WarehouseBean warehouse) {
		return wDAO.save(warehouse);
	}
	
	public WarehouseBean getOneWarehouseById(Integer id) {
		Optional<WarehouseBean>optional = wDAO.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public List<WarehouseBean> getAllWarehouse(){
		return wDAO.findAll();
	}
	
	public void deleteWarehouseById(Integer id) {
		 wDAO.deleteById(id);
	}
	
	public WarehouseBean updateWarehouse(WarehouseBean warehouse) {
		return wDAO.save(warehouse);
	}
	
}
