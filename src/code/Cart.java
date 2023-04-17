package medal;

import java.util.HashMap;

public class Cart {
	HashMap <Item, Integer> cartItems = new HashMap <Item, Integer>();
	
	public void addItem(Item item, Integer amt) {
		cartItems.put(item, amt);
	}
	
	public void setQuantity(Item item, Integer amt) { //is this the way to go
		cartItems.put(item,amt);
	}
	
	public void incQuantityBy1(Item item) {
		cartItems.put(item, cartItems.get(item)+1);
	}
	
	public void decQuantityBy1(Item item) {
		cartItems.put(item, cartItems.get(item)-1);
	}
	

}
