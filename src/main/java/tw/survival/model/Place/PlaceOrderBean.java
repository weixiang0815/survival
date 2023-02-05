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

	@Temporal(TemporalType.TIMESTAMP) // 訂單日期
	@Column(name = "order_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date order_date;

	@Temporal(TemporalType.TIMESTAMP) // 使用日期
	@Column(name = "use_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date use_date;

	@Column(name = "use_timespan")
	private String use_timespan; //使用時段

//	private Integer fk_player_id;

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

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Date getUse_date() {
		return use_date;
	}

	public void setUse_date(Date use_date) {
		this.use_date = use_date;
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

}
