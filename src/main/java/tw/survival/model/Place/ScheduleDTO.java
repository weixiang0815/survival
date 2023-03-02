package tw.survival.model.Place;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("title")
	private String title;
	
	@JsonProperty("start")
	private Date start;
	
	@JsonProperty("end")
	private Date end;

	public ScheduleDTO() {
	}

	public ScheduleDTO(String title, Date start, Date end) {
		this.title = title;
		this.start = start;
		this.end = end;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

}
