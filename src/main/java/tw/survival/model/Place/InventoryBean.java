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
	@Column(name="id")
	private Integer id;
	
	@Column(name="inventory_sellamount")
	private Integer inventory_sellamount; //販賣庫存
	

	@Column(name="inventory_rentamount")
	private Integer inventory_rentamount; //租借庫存

	@JsonBackReference
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fk_warehouse_id")
	private WarehouseBean warehouse;
	
	@JsonBackReference
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


	public Integer getInventory_sellamount() {
		return inventory_sellamount;
	}

	public void setInventory_sellamount(Integer inventory_amount) {
		this.inventory_sellamount = inventory_amount;
	}



	public WarehouseBean getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WarehouseBean warehouse) {
		this.warehouse = warehouse;
	}

	public Integer getInventory_rentamount() {
		return inventory_rentamount;
	}

	public void setInventory_rentamount(Integer inventory_rentamount) {
		this.inventory_rentamount = inventory_rentamount;
	}


	public ProductBean getProduct() {
		return product;
	}

	public void setProduct(ProductBean product) {
		this.product = product;
	}

	
	
}
