package hust.soict.globalict.aims;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.factory.BookCreation;
import hust.soict.globalict.aims.media.factory.CDCreation;
import hust.soict.globalict.aims.media.factory.DVDCreation;
import hust.soict.globalict.aims.media.factory.MediaCreation;
import hust.soict.globalict.aims.order.Order;

public class Aims {
	public static Media createMedia(MediaCreation mc) {
		return mc.createMediaFromConsole();
	}

	public static void main(String[] args) {

		// Admin menu
		Scanner scanner = new Scanner(System.in);
		ArrayList<Media> listOfMedias = new ArrayList<Media>();

		DVDCreation dvdCreation = new DVDCreation();
		CDCreation cdCreation = new CDCreation();
		BookCreation bookCreation = new BookCreation();

		int adminOption;
		do {
			System.out.println("Product Management Application: ");
			System.out.println("--------------------------------");
			System.out.println("1. Create new item");
			System.out.println("2. Delete item by id");
			System.out.println("3. Display the items list");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
			System.out.print("Enter the number here: ");
			adminOption = scanner.nextInt();

			switch (adminOption) {
				case 1:
					System.out.print("Which type of item do you want to create? (Book, CD or DVD)?\n" +
							"If Book, type Book\n" +
							"If CD, type CD\n" +
							"If DVD, type DVD\n" +
							"Enter your choice (case is insensitive) : ");
					String choice = scanner.next();
					if (choice.equalsIgnoreCase("book")) {
						Media bookMedia = createMedia(bookCreation);
						listOfMedias.add(bookMedia);
					} else if (choice.equalsIgnoreCase("cd")) {
						Media cdMedia = createMedia(cdCreation);
						listOfMedias.add(cdMedia);
					} else if (choice.equalsIgnoreCase("dvd")) {
						Media dvdMedia = createMedia(dvdCreation);
						listOfMedias.add(dvdMedia);
					}

					System.out.println();
					break;
				case 2:
					System.out.print("Enter the id of item which you want to delete: ");
					int id = scanner.nextInt();
					listOfMedias.remove(id);
					System.out.println("The media has been removed from the list!");
					break;
				case 3:
					for (int i = 0; i < listOfMedias.size(); i++) {
						var media = listOfMedias.get(i);
						System.out.print((i + 1) + "." +
								" Title: " + media.getTitle() +
								" - Category: " + media.getCategory() +
								" - Cost: $" + media.getCost());
						if (media instanceof Book) {
							System.out.println(" - Authors: " + ((Book) media).authorsInfo());
						} else if (media instanceof CompactDisc) {
							System.out.print(" - Director: " + ((CompactDisc) media).getDirector() + " - Length: " + ((CompactDisc) media).getLength() + " - Artist: " + ((CompactDisc) media).getArtist() + " \n- Tracks:\n");
							((CompactDisc) media).tracksInfo(0);
						} else if (media instanceof DigitalVideoDisc) {
							System.out.println(" - Director: " + ((DigitalVideoDisc) media).getDirector() + " - Length: " + ((DigitalVideoDisc) media).getLength());
						} else {
							System.out.println("The value is invalid!");
						}
					}
					break;
			}
		} while (adminOption != 0);

		System.out.println();

		// User menu
		ArrayList<Order> listOfOrders = new ArrayList<Order>();
		int numericalOrder = 0;

		do {
			System.out.println("Welcome to AIMS Store: ");
			System.out.println("--------------------------------");
			System.out.println("1. Create new order");
			System.out.println("2. Search for an item from the list by title");
			System.out.println("3. Add item to order by id (id in the list of available items of the store)");
			System.out.println("4. Remove item from order by id (id in the order)");
			System.out.println("5. Display the order information");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4-5");
			System.out.print("Enter the number here: ");
			int userOption = scanner.nextInt();

			switch (userOption) {
				case 1:
					Order order = Order.createOrder();
					listOfOrders.add(order);
					System.out.println();
					break;
				case 2:
					boolean isSearch = false;
					System.out.print("Enter the title of item which you want to search: ");
					String searchTitle = scanner.next();
					for (int i = 0; i < listOfOrders.size(); i++) {
						for (int j = 0; j < listOfOrders.get(i).getItemsOrdered().size(); j++) {
							var media = listOfOrders.get(i).getItemsOrdered().get(j);
							if (media.getTitle().equalsIgnoreCase(searchTitle)) {
								isSearch = true;
								System.out.println("The item found!");
								System.out.print("ID: " + j +
										" - Kind: " + media.getClass() +
										" - Title: " + media.getTitle() +
										" - Category: " + media.getCategory() +
										" - Cost: " + media.getCost());
								if (media instanceof DigitalVideoDisc) {
									System.out.println(" - Director: " + ((DigitalVideoDisc) media).getDirector() + " - Length: " + ((DigitalVideoDisc) media).getLength());
								} else if (media instanceof CompactDisc) {
									System.out.println(" - Director: " + ((CompactDisc) media).getDirector() + " - Length: " + ((CompactDisc) media).getLength() + " - Artist: " + ((CompactDisc) media).getArtist());
								} else if (media instanceof Book) {
									System.out.println();
								}
							}
						}
					}
					if (isSearch == false) {
						System.out.println("Cannot find the item in the list of orders!");
					}
					break;
				case 3:
					System.out.print("Enter the id of the item which you want to add: ");
					int addId = scanner.nextInt();
					boolean isAdd = false;
					for (int i = 0; i < listOfMedias.size(); i++) {
						if (addId == i) {
							isAdd = true;
							listOfOrders.get(numericalOrder).addMedia(listOfMedias.get(addId));
						}
					}
					if (isAdd == false) {
						System.out.println("Cannot add the item!");
					}
					break;
				case 4:
					System.out.print("Enter the id of the item which you want to remove: ");
					int removeId = scanner.nextInt();
					listOfOrders.get(numericalOrder).removeMediaByID(removeId);
					System.out.println();
					break;
				case 5:
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
