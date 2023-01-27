package tw.suvival.model;

public class House {

	private Integer houseid;
	private String housename;

	public House() {
	}

	public House(Integer houseid, String housename) {
		this.houseid = houseid;
		this.housename = housename;
	}

	public Integer getHouseid() {
		return houseid;
	}

	public void setHouseid(Integer houseid) {
		this.houseid = houseid;
	}

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("House [houseid=");
		builder.append(houseid);
		builder.append(", housename=");
		builder.append(housename);
		builder.append("]");
		return builder.toString();
	}

}