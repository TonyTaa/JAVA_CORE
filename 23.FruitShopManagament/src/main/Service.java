package main;

import java.util.ArrayList;
import java.util.Hashtable;

public class Service {
	private ArrayList<Fruit> fruits = new ArrayList<>();
	private Hashtable<String, ArrayList<Order>> orders = new Hashtable<>();

	// ================= CREATE FRUIT =================
	public void addFruit(Fruit fruit) {
		fruits.add(fruit);
	}

	public ArrayList<Fruit> getFruits() {
		return fruits;
	}

	// ================= SHOPPING =================
	public Fruit getFruitByIndex(int index) {
		if (index < 1 || index > fruits.size())
			return null;
		return fruits.get(index - 1);
	}

	public void addToCart(ArrayList<Order> cart, Fruit fruit, int qty) {
		for (Order o : cart) {
			if (o.getFruitName().equalsIgnoreCase(fruit.getName())) {
				// fruit đã tồn tại trong cart
				o.setQuantity(o.getQuantity() + qty);
				return;
			}
		}
		// fruit chưa tồn tại
		cart.add(new Order(fruit.getName(), qty, fruit.getPrice()));
	}

	public void addOrder(String customer, ArrayList<Order> cart) {
		orders.put(customer, cart);
	}

	public Hashtable<String, ArrayList<Order>> getOrders() {
		return orders;
	}
}
