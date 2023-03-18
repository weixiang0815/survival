package tw.survival.model.Market;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartToOrderDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Integer> productIds = new ArrayList<>();
	
	private Integer playerId;

}