package structural.bridge;

public class BridgePatternDemo {
	public static void main(String[]strings) {
		Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());
		Shape redCircle = new Circle(100, 100, 10, new RedCircle());
		
		greenCircle.draw();
		redCircle.draw();
	}
}
