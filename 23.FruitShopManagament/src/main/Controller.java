package main;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class Controller {

	private Service service = new Service();
	private Validation validation = new Validation();

	public void run() {
		while (true) {
			System.out.println("\nFRUIT SHOP SYSTEM");
			System.out.println("1. Create Fruit");
			System.out.println("2. View orders");
			System.out.println("3. Shopping");
			System.out.println("4. Exit");
			System.out.print("Please choose: ");

			int choice = validation.checkValidateNumberInRange(1, 4);

			switch (choice) {
			case 1:
				createFruit();
				break;
			case 2:
				viewOrders();
				break;
			case 3:
				shopping();
				break;
			case 4:
				System.out.println(">> Exit program.");
				return;
			}
		}
	}

	// ================= CREATE FRUIT =================
	private void createFruit() {
		System.out.println("\n=== CREATE FRUIT ===");

		while (true) {
			System.out.print("Fruit ID: ");
			String id = validation.checkValidateText();

			System.out.print("Fruit name: ");
			String name = validation.checkValidateText();

			System.out.print("Price: ");
			double price = validation.checkValidateDouble();

			System.out.print("Quantity: ");
			int quantity = validation.checkValidateNumber();

			System.out.print("Origin: ");
			String origin = validation.checkValidateText();

			service.addFruit(new Fruit(id, name, price, quantity, origin));
			System.out.println(">> Fruit created successfully.");

			System.out.print("Do you want to continue (Y/N): ");
			if (!validation.checkYesNo()) {
				System.out.println(">> Return to main menu.");
				break;
			}
		}
	}

	// ================= SHOPPING =================
	private void shopping() {
		if (service.getFruits().isEmpty()) {
			System.out.println(">> Fruit list is empty. Please create fruit first.");
			return;
		}

		ArrayList<Order> cart = new ArrayList<>();

		while (true) {
			showFruitList();

			System.out.print("Select item: ");
			int item = validation.checkValidateNumberInRange(1, service.getFruits().size());

			Fruit fruit = service.getFruitByIndex(item);

			if (fruit.getQuantity() == 0) {
				System.out.println(">> This fruit is out of stock.");
				continue;
			}

			System.out.println("You selected: " + fruit.getName());
			System.out.print("Please input quantity: ");
			int qty = validation.checkValidateNumberInRange(1, fruit.getQuantity());

			fruit.setQuantity(fruit.getQuantity() - qty);

			// gọi service để xử lý gộp cart
			service.addToCart(cart, fruit, qty);

			System.out.println(">> Added to cart.");

			System.out.print("Do you want to order now (Y/N): ");
			if (validation.checkYesNo()) {
				break;
			}
		}

		if (cart.isEmpty()) {
			System.out.println(">> Cart is empty. Order cancelled.");
			return;
		}

		showCart(cart);

		System.out.print("Input your name: ");
		String name = validation.checkValidateText();
		service.addOrder(name, cart);

		System.out.println(">> Order placed successfully.");
	}

	private void showFruitList() {
		ArrayList<Fruit> list = service.getFruits();

		if (list.isEmpty()) {
			System.out.println(">> No fruit available.");
			return;
		}

		System.out.println("\nList of Fruit:");
		System.out.println("| Item | Name | Origin | Price |");

		boolean hasFruit = false;

		for (int i = 0; i < list.size(); i++) {
			Fruit f = list.get(i);
			if (f.getQuantity() > 0) {
				System.out.printf("%d\t%s\t%s\t%.2f$\n", i + 1, f.getName(), f.getOrigin(), f.getPrice());
				hasFruit = true;
			}
		}

		if (!hasFruit) {
			System.out.println(">> All fruits are out of stock.");
		}
	}

	private void showCart(ArrayList<Order> cart) {
		double total = 0;

		System.out.println("\nProduct | Quantity | Price | Amount");

		for (Order o : cart) {
			System.out.printf("%s\t%d\t%.2f$\t%.2f$\n", o.getFruitName(), o.getQuantity(), o.getPrice(), o.getAmount());
			total += o.getAmount();
		}
		System.out.println("Total: " + total + "$");
	}

	// ================= VIEW ORDERS =================
	private void viewOrders() {
		Hashtable<String, ArrayList<Order>> orders = service.getOrders();

		if (orders.isEmpty()) {
			System.out.println(">> No orders yet.");
			return;
		}

		System.out.println("\n=== ORDER LIST ===");

		for (Map.Entry<String, ArrayList<Order>> entry : orders.entrySet()) {
			System.out.println("\nCustomer: " + entry.getKey());
			showCart(entry.getValue());
		}
	}
}
