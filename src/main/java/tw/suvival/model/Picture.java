package tw.suvival.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "picture")
@Component
public class Picture {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "FILENAME")
	private String filename;
	
	@Column(name = "PICTURE")
	private byte[] picture;

	public Picture() {
		super();
	}

	public Picture(String filename, byte[] picture) {
		this.filename = filename;
		this.picture = picture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Picture [id=");
		builder.append(id);
		builder.append(", filename=");
		builder.append(filename);
		builder.append("]");
		return builder.toString();
	}
}