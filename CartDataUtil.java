package Servlets;

import java.util.ArrayList;
import java.util.List;


public class CartDataUtil {
	public static List<Cart> getCarts(){
		
		// create an empty list
		List<Cart> carts = new ArrayList<>();
		
		// add sample data
		carts.add(new Cart("Java Servlet Programming", 29.95));
		carts.add(new Cart("Oracle Database Programming", 48.95));
		carts.add(new Cart("Java Web Services", 27.99));
		carts.add(new Cart("Justified by Justin Timberlake", 9.95));
		carts.add(new Cart("Gold Dogger by Kanye West", 8.95));
		carts.add(new Cart("Sorry by Juston Beiber", 7.99));
		carts.add(new Cart("Apple MacBook Pro with 13.3 Display", 1299.95));
		carts.add(new Cart("Asus Laptop with Centino 2 Black", 958.95));
		carts.add(new Cart("Sony VAIO Laptop with Core 2Duo Pink", 770.99));
		
		// return the list
		return carts;
	}
}
