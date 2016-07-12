package structural.decorator;

public class RedShapeDecorator extends ShapeDecorator {
	
	public RedShapeDecorator(Shape decorShape) {
		super(decorShape);
	}
	
	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}
	
	private void setRedBorder(Shape decorShape) {
		System.out.println("Border Color: Red");
	}

}
