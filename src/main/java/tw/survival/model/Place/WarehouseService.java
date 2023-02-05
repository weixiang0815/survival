package tw.survival.model.Place;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class WarehouseService {
	
	@Autowired
	private WarehouseDAO wDAO;
	

	public WarehouseService() {
	}

	
	public WarehouseBean addWarehouse(WarehouseBean warehouse) {
		return wDAO.addWarehouse(warehouse);
	}
	
	public WarehouseBean getOneWarehouseById(Integer id) {
		return wDAO.getOneWarehouseById(id);
	}
	
	public List<WarehouseBean> getAllWarehouse(){
		return wDAO.getAllWarehouse();
	}
	
	public String deleteWarehouseById(Integer id) {
		return wDAO.deleteWarehouseById(id);
	}
	
	public boolean updateWarehouse(WarehouseBean warehouse) {
		return wDAO.updateWarehouse(warehouse);
	}
	
}
