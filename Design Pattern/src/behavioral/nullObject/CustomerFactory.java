package behavioral.nullObject;

public class CustomerFactory {
	public static final String[] names = {"Rob", "Joe", "Julie"};
	
	public static AbstractCustomer getCustomer(String name) {
		for (String customer: names) {
			if (customer.equalsIgnoreCase(name)) {
				return new RealCustomer(name);
			}
		}
		return new NullCustomer();
	}
}
