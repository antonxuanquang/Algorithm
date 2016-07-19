package two;

public class Manager extends Employee{
	
	public Manager() {
		this.level = Employee.MANAGER;
		this.name = "Manager";
	}
	
	@Override
	void handleCall(String message) {
		System.out.println("Manager handle the call with message: " + message);
	}

}
