package j2ee.businessDelegate;

public class BusinessDelegate {
	private BusinessLookup lookup = new BusinessLookup();
	private BusinessService service;
	private String serviceType;
	
	public void setServiceType(String type) {
		serviceType = type;
	}
	
	public void doTask() {
		service = lookup.getBusinessService(serviceType);
		service.doProcessing();
	}
}
