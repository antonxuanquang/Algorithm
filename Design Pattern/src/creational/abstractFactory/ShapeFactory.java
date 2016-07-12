package creational.abstractFactory;

public class ShapeFactory extends AbstractFactory{

	@Override
	Color getColor(String color) {
		return null;
	}

	@Override
	Shape getShape(String shape) {
		if (shape == null) return null;
		
		if 		(shape.equalsIgnoreCase("circle")) 		return new Circle();
		else if (shape.equalsIgnoreCase("rectangle")) 	return new Rectangle();
		else if (shape.equalsIgnoreCase("triangle")) 	return new Triangle();
		
		return null;
	}

}
