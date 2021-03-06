package creational.abstractFactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String options) {
		if (options.equalsIgnoreCase("shape"))
			return new ShapeFactory();
		else if (options.equalsIgnoreCase("color"))
			return new ColorFactory();
		
		return null;
	}
}
