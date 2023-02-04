package tw.survival.model.Place;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Inventory")
@Component
public class InventoryBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="inventory_name")
	private String inventory_name;
	
	@Column(name="inventory_sellamount")
	private String inventory_sellamount; //販賣庫存
	
	@Column(name="inventory_address", unique = true)
	private String inventory_address;
	
	@Column(name="inventory_rentamount")
	private String inventory_rentamount; //租借庫存
	
	@Column(name = "fk_warehouse_id")
	@Transient
	private Integer warehouseid;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fk_warehouse_id")
	private WarehouseBean warehouse;
	
//	private fk_product_id;
	
	
	public InventoryBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInventory_name() {
		return inventory_name;
	}

	public void setInventory_name(String inventory_name) {
		this.inventory_name = inventory_name;
	}

	public String getInventory_sellamount() {
		return inventory_sellamount;
	}

	public void setInventory_sellamount(String inventory_amount) {
		this.inventory_sellamount = inventory_amount;
	}

	public String getInventory_address() {
		return inventory_address;
	}

	public void setInventory_address(String inventory_address) {
		this.inventory_address = inventory_address;
	}

	public Integer getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(Integer warehouseid) {
		this.warehouseid = warehouseid;
	}

	public WarehouseBean getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WarehouseBean warehouse) {
		this.warehouse = warehouse;
	}

	public String getInventory_rentamount() {
		return inventory_rentamount;
	}

	public void setInventory_rentamount(String inventory_rentamount) {
		this.inventory_rentamount = inventory_rentamount;
	}

	
	
}
