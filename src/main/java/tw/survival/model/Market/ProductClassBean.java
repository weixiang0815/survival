package tw.survival.model.Market;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="productclass")
@Component
public class ProductClassBean {
	
	@Id
	@Column(name = "id")
	@OneToOne(mappedBy = "fk_product_class_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JoinColumn(name = "fk_product_inventory_id")
	@OneToOne(cascade =CascadeType.ALL)
	private Integer fk_product_inventory_id;
	
	@JoinColumn(name = "fk_borrow_id")
	@OneToOne(cascade =CascadeType.ALL)
	private Integer fk_borrow_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFk_product_inventory_id() {
		return fk_product_inventory_id;
	}

	public void setFk_product_inventory_id(Integer fk_product_inventory_id) {
		this.fk_product_inventory_id = fk_product_inventory_id;
	}

	public Integer getFk_borrow_id() {
		return fk_borrow_id;
	}

	public void setFk_borrow_id(Integer fk_borrow_id) {
		this.fk_borrow_id = fk_borrow_id;
	}

}

