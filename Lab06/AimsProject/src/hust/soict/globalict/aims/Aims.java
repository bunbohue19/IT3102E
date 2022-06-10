package hust.soict.globalict.aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.order.Order;

public class Aims {
	
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void main(String[] args) {
		List<Order> listOfOrders = new ArrayList<Order>();
		int numericalOrder = 0;

		Scanner scanner = new Scanner(System.in);
		do {
			showMenu();
			int option = scanner.nextInt();
			switch (option) {
				case 1:
					Order order = Order.createOrder();
					listOfOrders.add(order);
					System.out.println();
					break;
				case 2:
					System.out.print("Which type of item do you want to add? (Book, CD or DVD)?\n" + 
					"If book, type Book\n" +
					"If CD, type CD\n" + 
					"If DVD, type DVD\n" + 
					"Enter your choice (case is insensitive) : ");
					String choice = scanner.next();
					if (choice.equalsIgnoreCase("book")) {
						Book book = new Book();
						book.setTitle("loc");
						book.setCategory("seo");
						book.setCost(100);
						listOfOrders.get(numericalOrder).addMedia(book);
					} else if (choice.equalsIgnoreCase("cd")) {
						CompactDisc cd = new CompactDisc();
						cd.setTitle("nguyen");
						cd.setCategory("dinh");
						cd.setCost(200);
						listOfOrders.get(numericalOrder).addMedia(cd);
					} else if (choice.equalsIgnoreCase("dvd")) {
						DigitalVideoDisc dvd = new DigitalVideoDisc();
						dvd.setTitle("ict");
						dvd.setCategory("soict");
						dvd.setCost(300);
						listOfOrders.get(numericalOrder).addMedia(dvd);
					}
					System.out.println();
					break;
				case 3:
					System.out.print("Enter the id of item which you want to delete: ");
					int id = scanner.nextInt();
					listOfOrders.get(numericalOrder).removeMediaByID(id);
					System.out.println();
					break;
				case 4:
					for (int i = 0; i < listOfOrders.size(); i++) {
						listOfOrders.get(i).printTheInfoOfOrder();
						System.out.println();
					}
					break;
				case 0:
					System.exit(0);
			}
		} while (true);
	}

}
