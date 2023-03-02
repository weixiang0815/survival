package tw.survival.model.Place;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("title")
	private String title;
	
	@JsonProperty("start")
	private String start;
	
	@JsonProperty("end")
	private String end;

	public ScheduleDTO() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public ScheduleDTO(String title, String start, String end) {
		super();
		this.title = title;
		this.start = start;
		this.end = end;
	}

	

}
