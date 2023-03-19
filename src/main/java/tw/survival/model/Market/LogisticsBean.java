package tw.survival.model.Market;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import tw.survival.model.Player.PlayerBean;

@Entity
@Table(name = "Logistics")
@Component
public class LogisticsBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP) // 如果用 sql.Date, 這行不用寫
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	@Column(name = "start_date")
	private Date start_date;

	@Temporal(TemporalType.TIMESTAMP) // 如果用 sql.Date, 這行不用寫
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	@Column(name = "arrive_date")
	private Date arrive_date;

	@Column(name = "status")
	private String status;

//	接收者(player_id)
//	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_receiver_id")
	private PlayerBean player;

	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_orderitem_id")
	private OrderItemBean orderItem;

	public LogisticsBean() {
	}

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

	public PlayerBean getPlayer() {
		return player;
	}

	public void setPlayer(PlayerBean player) {
		this.player = player;
	}

	public OrderItemBean getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItemBean orderItem) {
		this.orderItem = orderItem;
	}

}