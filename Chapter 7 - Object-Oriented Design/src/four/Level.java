package four;

public class Level {
	private int capacity;
	private String name;
	private Slot[] slots;
	
	public Level(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		
		slots = new Slot[capacity];
		for (int i = 0; i < capacity; i++) {
			slots[i] = new Slot();
		}
	}
	
	public Slot getASlot() throws Exception {
		if (isEmpty()) throw new Exception("This level is full");
		for (Slot slot: slots) {
			if (!slot.isUsed()) {
				capacity--;
				return slot;
			}
		}
		return null;
	}
	
	public void printCost() {
		System.out.println("Cost for level" + name);
		for (Slot slot: slots) {
			if (slot.isUsed()) {
				Car car = slot.getCar();
				System.out.println(car.cost());
			}
		}
	}
	
	public boolean isEmpty() {
		return capacity == 0;
	}
}
