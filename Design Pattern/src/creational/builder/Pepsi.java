package creational.builder;

public class Pepsi extends ColdDrink {

	public String name() {
		return "Pepsi";
	}

	@Override
	public float price() {
		return 35.0f;
	}

}
