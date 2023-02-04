package tw.survival.model.Market;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="borrowinventory")
@Component
public class BorrowInventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToOne(mappedBy = "fk_borrow_id")
	@Column(name="id")
	private Integer id;
	
	@Column(name="amount")
	private Integer amount;
	
	@Column(name="fee")
	private String fee;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}
	
}
