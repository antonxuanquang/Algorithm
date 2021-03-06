package creational.factory;

public class ShapeFactory {
	public static Shape createShape(String shapeType) {
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("TRIANGLE")) {
			return new Triangle();
		} else return null;
	}
}
