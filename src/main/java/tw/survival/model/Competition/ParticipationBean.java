package tw.survival.model.Competition;

import javax.persistence.Entity;
import javax.persistence.Table;

import tw.survival.model.User.UserBean;

@Entity
@Table(name = "Participation")
public class ParticipationBean {

	private Integer competitionId;

	private CompetitionBean competition;

	private Integer playerId;

	private UserBean player;

//	private Integer crewId;
//	
//	private CrewBean crew;

	public ParticipationBean() {
		super();
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