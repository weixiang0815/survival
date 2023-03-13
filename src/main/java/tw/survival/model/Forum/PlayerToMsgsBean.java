package tw.survival.model.Forum;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import tw.survival.model.Player.PlayerBean;

@Entity
@Table(name = "PlayerToMsgs")
public class PlayerToMsgsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP) // 如果用 sql.Date, 這行不用寫
	@Column(name = "added")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date added;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_player_id")
	private PlayerBean player;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_msgs_id")
	private MsgsBean msgs;
	
	public PlayerToMsgsBean() {
	}

	@PrePersist // 當物件轉換成 Persistent 狀態，先做這件事
	public void onCreate() {
		if (added == null) {
			added = new Date();
		}
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PlayerBean getPlayer() {
		return player;
	}

	public void setPlayer(PlayerBean player) {
		this.player = player;
	}

	public MsgsBean getMsgs() {
		return msgs;
	}

	public void setMsgs(MsgsBean msgs) {
		this.msgs = msgs;
	}
	
	
	
}
