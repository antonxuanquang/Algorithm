package two;

public class Respondent extends Employee {

	public Respondent() {
		this.level = Employee.RESPONDENT;
		this.name = "Respondent";
	}
	
	@Override
	void handleCall(String message) {
		System.out.println("Respondent handle the call with message: " + message);
	}
	
}
