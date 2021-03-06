package creational.factory;

public class FactoryPatternDemo {
	public static void main(String[]strings) {
		ShapeFactory factory = new ShapeFactory();
		
		Shape shape1 = factory.createShape("CIRCLE");
		shape1.draw();
		
		Shape shape2 = factory.createShape("RECTANGLE");
		shape2.draw();
		
		Shape shape3 = factory.createShape("TRIANGLE");
		shape3.draw();		
	}
}
