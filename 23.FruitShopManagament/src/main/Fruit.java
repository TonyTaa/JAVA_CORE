package main;

public class Fruit {
	private String id;
	private String name;
	private double price;
	private int quantity;
	private String origin;

	public Fruit(String id, String name, double price, int quantity, String origin) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.origin = origin;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrigin() {
		return origin;
	}
}
