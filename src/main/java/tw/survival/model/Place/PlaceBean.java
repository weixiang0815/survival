package tw.survival.model.Place;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Place")
@Component
public class PlaceBean {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="place_name")
	private String place_name;
	
	@Column(name="place_address")
	private String place_address;
	
	@Column(name="place_photo")
	private byte[] place_photo;
	
	@Column(name="place_fee")
	private String place_fee;
	
	@Column(name="place_capacity")
	private String place_capacity;
	
//	@OneToMany()
//	private Manager manager;
	
	public PlaceBean() {
	}

	public PlaceBean(String place_name, String place_address, byte[] place_photo, String place_fee,
			String place_capacity) {
		super();
		this.place_name = place_name;
		this.place_address = place_address;
		this.place_photo = place_photo;
		this.place_fee = place_fee;
		this.place_capacity = place_capacity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	public String getPlace_address() {
		return place_address;
	}

	public void setPlace_address(String place_address) {
		this.place_address = place_address;
	}

	public byte[] getPlace_photo() {
		return place_photo;
	}

	public void setPlace_photo(byte[] place_photo) {
		this.place_photo = place_photo;
	}

	public String getPlace_fee() {
		return place_fee;
	}

	public void setPlace_fee(String place_fee) {
		this.place_fee = place_fee;
	}

	public String getPlace_capacity() {
		return place_capacity;
	}

	public void setPlace_capacity(String place_capacity) {
		this.place_capacity = place_capacity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlaceBean [id=");
		builder.append(id);
		builder.append(", place_name=");
		builder.append(place_name);
		builder.append(", place_address=");
		builder.append(place_address);
		builder.append(", place_photo=");
		builder.append(Arrays.toString(place_photo));
		builder.append(", place_fee=");
		builder.append(place_fee);
		builder.append(", place_capacity=");
		builder.append(place_capacity);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
