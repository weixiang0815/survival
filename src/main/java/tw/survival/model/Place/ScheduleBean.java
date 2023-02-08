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


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import tw.survival.model.Competition.CompetitionBean;

@Entity
@Table(name = "Schedule")
@Component
public class ScheduleBean {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "schedule_name")
	private String schedule_name;

	@Column(name = "schedule_timespan")
	private String schedule_timespan; // 活動時段

	@Column(name = "schedule_status")
	private String schedule_status; // 排定狀態(已排定或是null)

	@Temporal(TemporalType.TIMESTAMP) // 如果用 sql.Date，這行不用寫
	@Column(name = "schedule_datetime")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date schedule_datetime;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_place_id")
	private PlaceBean place;;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_competition_id")
	private CompetitionBean competition;

	public ScheduleBean() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSchedule_name() {
		return schedule_name;
	}

	public void setSchedule_name(String schedule_name) {
		this.schedule_name = schedule_name;
	}

	public String getSchedule_timespan() {
		return schedule_timespan;
	}

	public void setSchedule_timespan(String schedule_timespan) {
		this.schedule_timespan = schedule_timespan;
	}

	public String getSchedule_status() {
		return schedule_status;
	}

	public void setSchedule_status(String schedule_status) {
		this.schedule_status = schedule_status;
	}

	public Date getSchedule_datetime() {
		return schedule_datetime;
	}

	public void setSchedule_datetime(Date schedule_datetime) {
		this.schedule_datetime = schedule_datetime;
	}

	public PlaceBean getPlace() {
		return place;
	}

	public void setPlace(PlaceBean place) {
		this.place = place;
	}

	public CompetitionBean getCompetition() {
		return competition;
	}

	public void setCompetition(CompetitionBean competition) {
		this.competition = competition;
	}

}
