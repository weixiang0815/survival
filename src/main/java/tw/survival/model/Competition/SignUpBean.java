package tw.survival.model.Competition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import tw.survival.model.User.UserBean;

@Entity
@Table(name = "SignUp")
@Component
public class SignUpBean {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private UserBean player;

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

	public UserBean getPlayer() {
		return player;
	}

	public void setPlayer(UserBean player) {
		this.player = player;
	}

}