package tw.survival.model.Market;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import tw.survival.model.Place.InventoryBean;
import tw.survival.model.Player.PlayerBean;

@Entity
@Table(name = "Logistics")
@Component
public class LogisticsBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "star_date")
	private Date star_date;

	@Column(name = "arrive_date")
	private Date arrive_date;

	@Column(name = "status")
	private String status;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_inventory_id")
	private InventoryBean Inventory;

//	接收者(player_id)
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_receiver_id")
	private PlayerBean Player;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_orderitem_id")
	private OrderItemBean OrderItem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStar_date() {
		return star_date;
	}

	public void setStar_date(Date star_date) {
		this.star_date = star_date;
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

	public InventoryBean getInventory() {
		return Inventory;
	}

	public void setInventory(InventoryBean inventory) {
		Inventory = inventory;
	}

	public PlayerBean getPlayer() {
		return Player;
	}

	public void setPlayer(PlayerBean player) {
		Player = player;
	}

	public OrderItemBean getOrderItem() {
		return OrderItem;
	}

	public void setOrderItem(OrderItemBean orderItem) {
		OrderItem = orderItem;
	}

}
