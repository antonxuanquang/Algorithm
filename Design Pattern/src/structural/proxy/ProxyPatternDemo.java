package structural.proxy;

public class ProxyPatternDemo {
	public static void main(String[] argsStrings) {
		Image image = new ProxyImage("test_10.jpg");
		
		image.display();
		System.out.println();
		
		image.display();
	}
}