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

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import tw.survival.model.Market.ProductBean;

@Entity
@Table(name = "Inventory")
@Component
public class InventoryBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "inventory_sellamount")
	private Integer inventorySellamount; // 販賣庫存

	@Column(name = "inventory_rentamount")
	private Integer inventoryRentamount; // 租借庫存

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_warehouse_id")
	private WarehouseBean warehouse;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_product_id")
	private ProductBean product;

//	@OneToMany(mappedBy = "inventory")
//	private List<LogisticsBean> logistics;
	
//	public List<LogisticsBean> getLogistics() {
//		return logistics;
//	}

//	public void setLogistics(List<LogisticsBean> logistics) {
//		this.logistics = logistics;
//	}

	public void setInventorySellamount(Integer inventorySellamount) {
		this.inventorySellamount = inventorySellamount;
	}

	public InventoryBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInventorySellamount() {
		return inventorySellamount;
	}

	public void setInventory_sellamount(Integer inventorySellamount) {
		this.inventorySellamount = inventorySellamount;
	}

	public Integer getInventoryRentamount() {
		return inventoryRentamount;
	}

	public void setInventoryRentamount(Integer inventoryRentamount) {
		this.inventoryRentamount = inventoryRentamount;
	}

	public WarehouseBean getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WarehouseBean warehouse) {
		this.warehouse = warehouse;
	}

	public ProductBean getProduct() {
		return product;
	}

	public void setProduct(ProductBean product) {
		this.product = product;
	}

}
