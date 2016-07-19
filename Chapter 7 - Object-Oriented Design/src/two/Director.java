package two;

public class Director extends Employee{

	public Director() { 
		this.level = Employee.DIRECTOR;
		this.name = "Director";
	}
	
	@Override
	void handleCall(String message) {
		System.out.println("Director handle the call with message: " + message);
	}

}
