package tw.survival.model.Place;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import tw.survival.model.Employee.EmployeeBean;

@Entity
@Table(name = "PlaceOrder")
@Component
public class PlaceOrderBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "fk_place_id")
	@Transient
	private Integer placeId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_place_id")
	private PlaceBean place;;

	 

	@Column(name = "use_timespan")
	private String use_timespan; //使用時段
	
	@Column(name="fk_player_id")
	@Transient
	private Integer playerId;
	
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="fk_player_id")
//	private PlayerBean player;
	
	@Column(name="fk_employee_id")
	@Transient
	private Integer employeeId;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="fk_player_id")
	private EmployeeBean employee;

	@Column(name = "order_status")
	private String order_status;

	public PlaceOrderBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getUse_timespan() {
		return use_timespan;
	}

	public void setUse_timespan(String use_timespan) {
		this.use_timespan = use_timespan;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Integer getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	public PlaceBean getPlace() {
		return place;
	}

	public void setPlace(PlaceBean place) {
		this.place = place;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeeBean getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}

	
}
