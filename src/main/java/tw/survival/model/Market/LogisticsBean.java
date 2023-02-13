package tw.survival.model.Market;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Logistics")
@Component
public class LogisticsBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="start_date")
	private Date start_date;
	
	@Column(name="arrive_date")
	private Date arrive_date;
	
	@Column(name="status")
	private String status;
	
//	private Integer fk_inventory_id;
//	
//	private Integer fk_receiver_id;
//	
//	private Integer fk_orderitem_id;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getArrive_date() {
		return arrive_date;
	}

	public void setArrive_date(Date arrive_date) {
		this.arrive_date = arrive_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
