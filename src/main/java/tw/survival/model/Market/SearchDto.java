package tw.survival.model.Market;

import java.io.Serializable;


public class SearchDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String[] productclass;

	private String[] name;

	private String[] price;


	public SearchDto() {
	}

}
