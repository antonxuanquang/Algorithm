package j2ee.businessDelegate;

public class BusinessLookup {
	public BusinessService getBusinessService(String type) {
		if (type.equalsIgnoreCase("EJB")) return new EBJService();
		else return new JMSService();
	}
}
