package four;

public class Parking {
	
	private Level[] levels;
	
	public Parking (int levels, int capacityOfLevel) {
		this.levels = new Level[levels];
		for (int i = 0; i < levels; i++) {
			this.levels[i] = new Level("" + (i + 1), capacityOfLevel);
		}
	}
	
	public Slot getASlot() throws Exception{ 
		if (isEmpry())throw new Exception("Parking is full"); 
		for (Level level: levels) {
			if (!level.isEmpty()) return level.getASlot();
		}
		return null;
	}
	
	boolean isEmpry() {
		for (Level level: levels) {
			if (!level.isEmpty()) return false;
		}
		return true;
	}
	
	public void print() { 
		for (Level level: levels) {
			level.printCost();
			System.out.println();
		}
	}
}
