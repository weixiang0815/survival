package tw.survival.model.Place;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("title")
	private String title;
	
	@JsonProperty("start")
	private String start;
	
	@JsonProperty("end")
	private String end;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("color")
	private String color;
	
	@JsonProperty("placeId")
	private String placeId;
	
	@JsonProperty("url")
	private String url;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ScheduleDTO(String title, String start, String end, String type, String color) {
		super();
		this.title = title;
		this.start = start;
		this.end = end;
		this.type = type;
		this.color = color;
		
	}
	

}
