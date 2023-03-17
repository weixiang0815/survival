package tw.survival.model.Market;

import java.io.Serializable;


public class ProductSearchDto implements Serializable {

	 private static final long serialVersionUID = 1L;

	 private String[] clazz;
	 private String[] context;
	 private String[] priceRange;

	 public ProductSearchDto() {
	 }

	public String[] getClazz() {
		return clazz;
	}

	public void setClazz(String[] clazz) {
		this.clazz = clazz;
	}

	public String[] getContext() {
		return context;
	}

	public void setContext(String[] context) {
		this.context = context;
	}

	public String[] getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(String[] priceRange) {
		this.priceRange = priceRange;
	}


	 
	}
