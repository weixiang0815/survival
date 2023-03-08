package tw.survival.service.Place;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Place.InventoryBean;
import tw.survival.model.Place.InventoryRepository;
import tw.survival.model.Place.WarehouseBean;
import tw.survival.model.Place.WarehouseRepository;

@Service
@Transactional
public class WarehouseService {

	@Autowired
	private WarehouseRepository wDAO;

	@Autowired
	private InventoryRepository iDAO;

	public WarehouseService() {
	}

	public WarehouseBean insertWarehouse(WarehouseBean warehouse) {
		return wDAO.save(warehouse);
	}

	public WarehouseBean getOneWarehouseById(Integer id) {
		Optional<WarehouseBean> optional = wDAO.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<WarehouseBean> getAllWarehouse() {
		return wDAO.findAll();
	}

	public void deleteWarehouseById(Integer id) {
		WarehouseBean warehouse = getOneWarehouseById(id);
		warehouse.setPlace(null);
		warehouse.setPlaceId(null);
		Set<InventoryBean> inventories = warehouse.getInventory();
//		for (InventoryBean inventory : inventories) {
//			iDAO.delete(inventory);
//		}
		inventories.forEach(inventory -> iDAO.delete(inventory));
		warehouse.setInventory(null);
		wDAO.deleteById(id);
	}

	public WarehouseBean updateWarehouse(WarehouseBean warehouse) {
		Optional<WarehouseBean> optional = wDAO.findById(warehouse.getId());
		if (optional.isPresent()) {
			WarehouseBean warehouseToUpdate = optional.get();
			warehouseToUpdate.setWarehouseName(warehouse.getWarehouseName());
			return wDAO.save(warehouseToUpdate);
		}
		return null;

	}

}