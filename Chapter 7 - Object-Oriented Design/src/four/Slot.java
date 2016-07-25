package four;

import java.util.NoSuchElementException;

public class Slot {
	
	private Car car;
	
	public void parkACar(Car car) {
		this.car = car;
	}
	
	public void clear() {
		if (car == null) throw new NoSuchElementException();
		car = null;
	}
	
	public Car getCar() {
		return car;
	}
	
	public boolean isUsed() {
		return car != null;
	}

}
