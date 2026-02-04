package main;

public class Order {
	private String fruitName;
	private int quantity;
	private double price;

	public Order(String fruitName, int quantity, double price) {
		this.fruitName = fruitName;
		this.quantity = quantity;
		this.price = price;
	}

	public double getAmount() {
		return quantity * price;
	}

	public String getFruitName() {
		return fruitName;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
