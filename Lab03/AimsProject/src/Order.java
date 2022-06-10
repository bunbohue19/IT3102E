
public class Order {

	public static final int MAX_NUMBERS_ORDERED = 10;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private static int qtyOrdered;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[++qtyOrdered] = disc; 
			System.out.println("The disc has been added");
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
}
