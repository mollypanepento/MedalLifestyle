

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicArrowButton;

public class Cart {
	public static ArrayList<Item> ItemList = new ArrayList<Item>();
	public static LinkedHashMap <Item, Integer> cartItems = new LinkedHashMap <Item, Integer>();
	public Cart() {
		
		
		// for (Item i : ItemList){
		//	addItem(i,  1);
		//}
		
	}
	
	
	
	public static void addItem(Item item, Integer amt) {
		cartItems.put(item, amt);
	}
	
	public void removeItem(Item item) {
		
		Iterator<Map.Entry<Item, Integer> >
        iterator = cartItems.entrySet().iterator();

	    // Iterate over the HashMap
	    while (iterator.hasNext()) {
	
	        // Get the entry at this iteration
	        Map.Entry<Item, Integer>
	            entry
	            = iterator.next();
	
	        // Check if this value is the required value
	        if (item.equals(entry.getKey())) {
	
	            // Remove this entry from HashMap
	            iterator.remove();
	        }
	    }
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
	
	public LinkedHashMap<Item, Integer> getItemsMap() {
		return cartItems;
	}
	
	public Integer getQuantity(Item item) {
		return cartItems.get(item);
	}
	
	public int getTotalAmtOfItems() {
		int total = 0;
		for(Integer i: cartItems.values()) {
			total += i;
		}
		return total;
	}
	
	public double getSubtotal() {
		double subtotal = 0.0;
		for(Item i: cartItems.keySet()) {
			double itemSpend = i.getPrice()*getQuantity(i);
			subtotal += itemSpend;
		}
		return subtotal;
	}

}
