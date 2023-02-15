package tw.survival.model.Place;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Warehouse")
@Component
public class WarehouseBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "warehouse_name")
	private String warehouseName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_place_id")
	private PlaceBean place;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse", cascade = CascadeType.ALL)
	private Set<InventoryBean> inventory = new LinkedHashSet<>();

	public WarehouseBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWarehouse_name() {
		return warehouseName;
	}

	public void setWarehouse_name(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public PlaceBean getPlace() {
		return place;
	}

	public void setPlace(PlaceBean place) {
		this.place = place;
	}

	public Set<InventoryBean> getInventory() {
		return inventory;
	}

	public void setInventory(Set<InventoryBean> inventory) {
		this.inventory = inventory;
	}

}
