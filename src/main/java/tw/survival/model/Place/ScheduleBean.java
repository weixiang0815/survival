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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Schedule")
@Component
public class ScheduleBean {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "schedule_timespan")
	private Integer scheduleTimespan; // 活動時段

	@Temporal(TemporalType.TIMESTAMP) // 如果用 sql.Date，這行不用寫
	@Column(name = "schedule_datetime")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date scheduleDatetime;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_place_id")
	private PlaceBean place;
	
	@Column(name="fk_place_id")
	@Transient
	private Integer placeId;

	public ScheduleBean() {
	}

	public ScheduleBean(Integer scheduleTimespan, Date scheduleDatetime, PlaceBean place) {
		this.scheduleTimespan = scheduleTimespan;
		this.scheduleDatetime = scheduleDatetime;
		this.place = place;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getScheduleTimespan() {
		return scheduleTimespan;
	}

	public void setScheduleTimespan(Integer scheduleTimespan) {
		this.scheduleTimespan = scheduleTimespan;
	}

	public Date getScheduleDatetime() {
		return scheduleDatetime;
	}

	public void setScheduleDatetime(Date scheduleDatetime) {
		this.scheduleDatetime = scheduleDatetime;
	}

	public PlaceBean getPlace() {
		return place;
	}

	public void setPlace(PlaceBean place) {
		this.place = place;
	}

	public Integer getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	
}
