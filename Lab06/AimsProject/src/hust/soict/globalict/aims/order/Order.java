package hust.soict.globalict.aims.order;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Order {

	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERS = 5;
	private static int nbOrders = 0;

	private Order() {

	}

	public static Order createOrder() {
		if (nbOrders > MAX_LIMITED_ORDERS) {
			return null;
		} else {
			nbOrders++;
			return new Order();
		}
	}
	
	public void addMedia(Media media) {
		itemsOrdered.add(media);
		if (media instanceof DigitalVideoDisc) {
			System.out.println("The DVD has been added to the list :D");
		}
		if (media instanceof Book) {
			System.out.println("The book has been added to the list :D");
		}
		if (media instanceof CompactDisc) {
			System.out.println("The CD has been added to the list :D");
		}
	}

	public void removeMedia(Media media) {
		for (Media m : itemsOrdered) {
			if (m.getTitle().equalsIgnoreCase(media.getTitle()) && m.getCategory().equalsIgnoreCase(media.getCategory())) {
				itemsOrdered.remove(m);
				if (media instanceof DigitalVideoDisc) {
					System.out.println("The DVD has been removed from the list :D");
				}
				if (media instanceof Book) {
					System.out.println("The book has been removed from the list :D");
				}
				if (media instanceof CompactDisc) {
					System.out.println("The CD has been removed from the list :D");
				}
				return;
			}
		}
		
		System.out.println("No media is founded in the list :(");
	}

	public void removeMediaByID(int id) {
		if (itemsOrdered.get(id) instanceof DigitalVideoDisc) {
			System.out.println("The DVD has been removed from the order :D");
		}
		if (itemsOrdered.get(id) instanceof Book) {
			System.out.println("The Book has been removed from the order :D");
		}
		if (itemsOrdered.get(id) instanceof CompactDisc) {
			System.out.println("The CD has been removed from the order :D");
		}
		itemsOrdered.remove(id);
	}

	public void printTheInfoOfOrder() {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i + 1) + "." + 
							" Title: " + itemsOrdered.get(i).getTitle() +
							" - Category: " + itemsOrdered.get(i).getCategory() +
							" - Cost: $" + itemsOrdered.get(i).getCost());
		}
	}

	public void totalCost() {
		float sum = 0.0f;
		for (Media m : itemsOrdered) {
			sum += m.getCost();
		}
		System.out.println("Total cost: $" + sum);
	}
}
