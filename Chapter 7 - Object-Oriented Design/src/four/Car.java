package four;

public class Car {
	private long getInTime;
	private String ticketNumber;
	private Slot slot;
	
	public Car(Slot slot) {
		this.slot = slot;
		slot.parkACar(this);
		getInTime = System.currentTimeMillis();
	}
	
	public double cost() {
		return (System.currentTimeMillis() - getInTime);
	}
}
