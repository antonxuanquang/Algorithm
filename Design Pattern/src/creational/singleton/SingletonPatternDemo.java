package creational.singleton;

public class SingletonPatternDemo {
	public static void main (String[] args) {
		
		// illegal construct
		// Compile Time error: The constructor SingleObject is not available
//		SingleObject object = new SingleObject();
		
		SingleObject object = SingleObject.getInstance();
		
		object.showMessage();
	}

}
