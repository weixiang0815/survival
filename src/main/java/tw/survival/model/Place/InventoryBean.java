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

import tw.survival.model.Market.ProductBean;

@Entity
@Table(name = "Inventory")
@Component
public class InventoryBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	
	
	@Column(name="inventory_sellamount")
	private String inventory_sellamount; //販賣庫存
	

	@Column(name="inventory_rentamount")
	private String inventory_rentamount; //租借庫存
	
	@Column(name = "fk_warehouse_id")
	@Transient
	private Integer warehouseId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fk_warehouse_id")
	private WarehouseBean warehouse;
	
	@Column(name = "fk_product_id")
	@Transient
	private Integer productId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fk_product_id")
	private ProductBean product;
	
	
	
	public InventoryBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getInventory_sellamount() {
		return inventory_sellamount;
	}

	public void setInventory_sellamount(String inventory_amount) {
		this.inventory_sellamount = inventory_amount;
	}


	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
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

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public ProductBean getProduct() {
		return product;
	}

	public void setProduct(ProductBean product) {
		this.product = product;
	}

	
	
}
