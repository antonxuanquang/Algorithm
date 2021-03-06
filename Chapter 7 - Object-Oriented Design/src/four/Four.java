package four;

public class Four {
	
	/*
	 * 
	 * Parking Lot: Design a parking lot using object-oriented principles
	 * 
	 */
	
	public static void main(String[] args) {
		Parking parking = new Parking(3, 40);
		for (int i = 0; i < 100; i++) {
			try {
				Car car = new Car(parking.getASlot());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		parking.print();
	}

}
