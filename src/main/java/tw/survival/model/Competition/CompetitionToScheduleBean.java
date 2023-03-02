package tw.survival.model.Competition;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import tw.survival.model.Place.ScheduleBean;

@Entity
@Table(name = "Competition_To_Schedule")
public class CompetitionToScheduleBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "fk_schedule_id")
	@Transient
	private Integer scheduleId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_schedule_id")
	private ScheduleBean schedule;

	@Column(name = "fk_competition_id")
	@Transient
	private Integer competitionId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_competition_id")
	private CompetitionBean competition;

	public CompetitionToScheduleBean() {
	}
	
	public CompetitionToScheduleBean(ScheduleBean schedule, CompetitionBean competition) {
		this.schedule = schedule;
		this.competition = competition;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public ScheduleBean getSchedule() {
		return schedule;
	}

	public void setSchedule(ScheduleBean schedule) {
		this.schedule = schedule;
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

}