package tw.survival.model.Place;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InventoryService {
	
	@Autowired
	private InventoryDAO iDAO;
	
	public InventoryService() {

	}

	public InventoryBean addInventory(InventoryBean inventory) {
		return iDAO.addInventory(inventory);
	}
	
	
	public InventoryBean getInventoryById(Integer id) {
		return iDAO.getInventoryById(id);
	}

	public List<InventoryBean> getAllInventory(){
		return iDAO.getAllInventory();
	}
	
	public String deleteInventoryById(Integer id) {
		return iDAO.deleteInventoryById(id);
	}
	
	public boolean updateInventory(InventoryBean inventory) {
		return iDAO.updateInventory(inventory);
	}
}
