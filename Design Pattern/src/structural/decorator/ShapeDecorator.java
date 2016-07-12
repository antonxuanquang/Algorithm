package structural.decorator;

public abstract class ShapeDecorator implements Shape {
	protected Shape decoratedShape;
	
	public ShapeDecorator(Shape decorShape) {
		decoratedShape = decorShape;
	}
	
	public void draw() {
		decoratedShape.draw();
	}
}
