package hust.soict.globalict.aims.order;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.MyDate;

public class Order {

	public static final int MAX_NUMBERS_ORDERED = 10;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private static int qtyOrdered;
	public static final int MAX_LIMITED_ORDERS = 5;
	private static int nbOrders = 0;

	private Order() {

	}

	public static void currentDate() {
		MyDate dateOrdered = new MyDate();
	}

	public static Order createOrder() {
		if (nbOrders > MAX_LIMITED_ORDERS) {
			return null;
		} else {
			nbOrders++;
			return new Order();
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[++qtyOrdered] = disc; 
			System.out.println("The disc has been added");
		} else {
			System.out.println("The order is full! Cannot add anymore");
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if (dvdList.length <= qtyOrdered) {
			for (int i = 1; i <= dvdList.length; i++) {
				itemsOrdered[++qtyOrdered] = dvdList[i];
				System.out.println("A list of dvd has been added");
			}
		} else {
			System.out.println("The order is full! Cannot add anymore");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		disc.setCategory(null);
		disc.setCost(0);
		disc.setDirector(null);
		disc.setLength(0);
		disc.setTitle(null);
		System.out.println("The disc has been removed!");
	}
	
	public float totalCost() {
		float sum = 0;
		for (int i = 1; i <= qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}

	public void printTheListOfOrderedItems() {
		System.out.print("Date: "); currentDate();
		System.out.println("**********************Order**********************");
		System.out.println("Ordered Items:");
		for (int i = 1; i <= qtyOrdered; i++) {
			System.out.println(i + ". DVD - " + itemsOrdered[i].getTitle() + " - "
											  + itemsOrdered[i].getCategory() + " - "
											  + itemsOrdered[i].getDirector() + " - "
											  + itemsOrdered[i].getLength() + ": $"
											  + itemsOrdered[i].getCost());
		}
		System.out.println("Total cost: $" + totalCost());
		System.out.println("*************************************************\n");
	}

	public DigitalVideoDisc getALuckyItem() {
		int max = 100;
        int min = 1;
        int range = max - min + 1;

		int rand = (int) (Math.random() * range) + min;

		if (rand % 3 == 0) {
			DigitalVideoDisc disc = new DigitalVideoDisc();
			disc.setTitle("A lucky Item");
			disc.setCategory("Optional");
			disc.setDirector("Optional");
			disc.setLength(100);
			disc.setCost(50.00f);
			addDigitalVideoDisc(disc);
			System.out.println("Congratulations! You have just gotten a lucky item for free\n");
			return disc;
		} else {
			System.out.println("Wish you luckier next time :(\n");
			return null;
		}
	}
}
