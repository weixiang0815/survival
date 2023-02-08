package tw.survival.service.Place;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.survival.model.Place.InventoryBean;
import tw.survival.model.Place.InventoryRepository;

@Service
@Transactional
public class InventoryService {
	
	@Autowired
	private InventoryRepository iDAO;
	
	public InventoryService() {

	}

	public InventoryBean insertInventory(InventoryBean inventory) {
		return iDAO.save(inventory);
	}
	
	
	public InventoryBean getInventoryById(Integer id) {
		Optional<InventoryBean> optional = iDAO.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<InventoryBean> getAllInventory(){
		return iDAO.findAll();
	}
	
	public void deleteInventoryById(Integer id) {
		 iDAO.deleteById(id);
	}
	
	public InventoryBean updateInventory(InventoryBean inventory) {
		return iDAO.save(inventory);
	}
}
