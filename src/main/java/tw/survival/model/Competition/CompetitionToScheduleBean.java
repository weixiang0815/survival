package tw.survival.model.Competition;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import tw.survival.model.Place.ScheduleBean;

@Entity
@Table(name = "Competition_To_Schedule")
public class CompetitionToScheduleBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_schedule_id")
	private ScheduleBean schedule;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_competition_id")
	private CompetitionBean competition;

	public CompetitionToScheduleBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ScheduleBean getSchedule() {
		return schedule;
	}

	public void setSchedule(ScheduleBean schedule) {
		this.schedule = schedule;
	}

	public CompetitionBean getCompetition() {
		return competition;
	}

	public void setCompetition(CompetitionBean competition) {
		this.competition = competition;
	}

}