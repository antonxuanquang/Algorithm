package j2ee.businessDelegate;

public class EBJService implements BusinessService {

	public void doProcessing() {
		System.out.println("Processing task by invoking EJB Service");
	}

}
