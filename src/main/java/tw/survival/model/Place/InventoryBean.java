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

	@Column(name = "fk_warehouse_id")
	@Transient
	private Integer warehouseId;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_product_id")
	private ProductBean product;

	@Column(name = "fk_product_id")
	@Transient
	private Integer productId;

//	@JsonManagedReference
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventory", cascade = CascadeType.ALL)
//	private Set<LogisticsBean> logistics = new LinkedHashSet<>();

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

	public void setInventorySellamount(Integer inventorySellamount) {
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

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

//	public Set<LogisticsBean> getLogistics() {
//		return logistics;
//	}
//
//	public void setLogistics(Set<LogisticsBean> logistics) {
//		this.logistics = logistics;
//	}

}