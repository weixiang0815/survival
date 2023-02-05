package tw.survival.model.Market;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "product")
@Component
public class ProductBean {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "img")
	private byte[] img;
	
	@Column(name = "name")
	private String name;

	@Column(name = "context")
	private String context;

	@Column(name = "local")
	private String local;

	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "fk_product_class_id")
	private Integer fk_product_class_id;

	public ProductBean() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getFk_product_class_id() {
		return fk_product_class_id;
	}

	public void setFk_product_class_id(Integer fk_product_class_id) {
		this.fk_product_class_id = fk_product_class_id;
	}

	
}

