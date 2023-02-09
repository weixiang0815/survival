package tw.survival.model.Market;

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

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import tw.survival.model.Player.PlayerBean;

@Entity
@Table(name="orderitem")
@Component
public class OrderItemBean {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="order_create_data")
	private Date order_create_data;
	
	@Column(name="status")
	private String status;
	
	@JsonBackReference
	@JoinColumn(name="fk_player_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private PlayerBean player;
	
	public OrderItemBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOrder_create_data() {
		return order_create_data;
	}

	public void setOrder_create_data(Date order_create_data) {
		this.order_create_data = order_create_data;
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

}