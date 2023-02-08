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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import tw.survival.model.Market.ProductBean;

@Entity
@Table(name = "Place")
@Component
public class PlaceBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "place_name")
	private String place_name;

	@Column(name = "place_address")
	private String place_address;

	@Lob
	@Column(name = "place_photo")
	private byte[] place_photo;

	@Column(name = "place_fee")
	private Integer place_fee;

	@Column(name = "place_capacity")
	private Integer place_capacity;

//	@JsonManagedReference
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "place", cascade = CascadeType.ALL)
//	private Set<EmployeeBean> employee = new LinkedHashSet<>();

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_product_id")
	private ProductBean product;

	@OneToOne(mappedBy = "place")
	private WarehouseBean warehouse; // 倉庫

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "place", cascade = CascadeType.ALL)
	private Set<PlaceOrderBean> placeOrder = new LinkedHashSet<>(); // 場地訂單

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "place", cascade = CascadeType.ALL)
	private Set<ScheduleBean> schedule = new LinkedHashSet<>(); // 活動排程表

	public PlaceBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	public String getPlace_address() {
		return place_address;
	}

	public void setPlace_address(String place_address) {
		this.place_address = place_address;
	}

	public byte[] getPlace_photo() {
		return place_photo;
	}

	public void setPlace_photo(byte[] place_photo) {
		this.place_photo = place_photo;
	}

	public Integer getPlace_fee() {
		return place_fee;
	}

	public void setPlace_fee(Integer place_fee) {
		this.place_fee = place_fee;
	}

	public Integer getPlace_capacity() {
		return place_capacity;
	}

	public void setPlace_capacity(Integer place_capacity) {
		this.place_capacity = place_capacity;
	}

//	public Set<EmployeeBean> getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Set<EmployeeBean> employee) {
//		this.employee = employee;
//	}

	public ProductBean getProduct() {
		return product;
	}

	public void setProduct(ProductBean product) {
		this.product = product;
	}

	public WarehouseBean getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WarehouseBean warehouse) {
		this.warehouse = warehouse;
	}

	public Set<PlaceOrderBean> getPlaceOrder() {
		return placeOrder;
	}

	public void setPlaceOrder(Set<PlaceOrderBean> placeOrder) {
		this.placeOrder = placeOrder;
	}

	public Set<ScheduleBean> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<ScheduleBean> schedule) {
		this.schedule = schedule;
	}

}