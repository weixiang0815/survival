package tw.survival.model.Market;

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

	//商品圖片
	@Column(name = "img")
	private byte[] img;
	
	//商品名稱
	@Column(name = "name")
	private String name;

	//商品敘述
	@Column(name = "context")  
	private String context;

	//商品分類(搜尋用)
	@Column(name = "class")
	private String product_class;
	
	//租賃價格
	@Column(name="rent_fee")
	private Integer rent_fee;
	
	//買賣價格
	@Column(name="price")
	private Integer price;
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "fk_product_class_id")
//	private ProductClassBean productClassBean;

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


	public String getProduct_class() {
		return product_class;
	}


	public void setProduct_class(String product_class) {
		this.product_class = product_class;
	}


	public Integer getRent_fee() {
		return rent_fee;
	}


	public void setRent_fee(Integer rent_fee) {
		this.rent_fee = rent_fee;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}

}