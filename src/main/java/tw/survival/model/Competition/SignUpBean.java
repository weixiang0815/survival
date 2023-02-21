package tw.survival.model.Competition;

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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import tw.survival.model.Player.PlayerBean;

@Entity
@Table(name = "SignUp")
public class SignUpBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "fk_competition_id")
	@Transient
	private Integer competitionId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_competition_id")
	private CompetitionBean competition;

	@Column(name = "fk_player_id")
	@Transient
	private Integer playerId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_player_id")
	private PlayerBean player;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	@Column(name = "signup_date")
	private Date signUpDate;

	@Column(name = "status")
	private String status;

	@PrePersist
	void onCreate() {
		if (signUpDate == null) {
			signUpDate = new Date();
		}
	}

	public SignUpBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(Integer competitionId) {
		this.competitionId = competitionId;
	}

	public CompetitionBean getCompetition() {
		return competition;
	}

	public void setCompetition(CompetitionBean competition) {
		this.competition = competition;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public PlayerBean getPlayer() {
		return player;
	}

	public void setPlayer(PlayerBean player) {
		this.player = player;
	}

	public Date getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}