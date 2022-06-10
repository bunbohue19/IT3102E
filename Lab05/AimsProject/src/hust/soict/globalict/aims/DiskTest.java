package hust.soict.globalict.aims;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.order.Order;

public class DiskTest {
    public static void main(String[] args) {
		// Test the search method
		DigitalVideoDisc dvd = new DigitalVideoDisc("Harry Potter");
		System.out.println(dvd.search("Potter"));
        
        Order anOrder = Order.createOrder();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		anOrder.addDigitalVideoDisc(dvd3);

		System.out.print("Total Cost is: ");
		System.out.println(anOrder.totalCost());
        
        // Before play the lucky game
		anOrder.printTheListOfOrderedItems();
        
        DigitalVideoDisc luckyItem = anOrder.getALuckyItem();

        // After play the lucky game
        anOrder.printTheListOfOrderedItems();
        
	}
}
