package onlineStore;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
	public  ArrayList<Item1> addedToWishList;
	public  HashMap<Item1, Integer> addedToCart;
	public double subtotal;
	
	public User() {
		addedToWishList = new ArrayList<Item1>();
		addedToCart = new HashMap<Item1, Integer>();
		subtotal = 0;
	}
	
	public  void addToWishList(Item1 i) {
		addedToWishList.add(i);
	}
	
	public void addToCart(Item1 item, Integer amt) {
		addedToCart.put(item, amt);
		subtotal += item.getPrice()*amt;
	}
	
	public  ArrayList<Item1> getWishList(){
		return addedToWishList;
	}
	
	public  HashMap<Item1, Integer> getCart(){
		return addedToCart;
	}
	
	public  void printWishList() {
		for(Item1 i : addedToWishList) {
			System.out.println(i.getName());
		}
	}
	
	public  void printCart() {
		for(Item1 i : addedToCart.keySet()) {
			System.out.println(i.getName());
		}
	}
	
	public Integer getQuantity(Item1 item) {
		return addedToCart.get(item);
	}
	
	public double getSubtotal() {
		return subtotal;
	}
	
}
