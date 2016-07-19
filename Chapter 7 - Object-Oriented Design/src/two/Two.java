package two;

public class Two {
	/*
	 * 
	 * Design classes and data structures for respondent, manager, and director.
	 * Implement a method dispatchCall() which assigns a call the the first available
	 * employee
	 * 
	 */
	
	public static void main(String[] args) {
		Employee respondent = new Respondent();
		Employee manager = new Manager();
		Employee director = new Director();
		
		respondent.setNextLevel(manager);
		manager.setNextLevel(director);
		
		respondent.dispatchCall("hello respondent", Employee.RESPONDENT);
		respondent.dispatchCall("hello manager", Employee.MANAGER);
		respondent.dispatchCall("hello director", Employee.MANAGER + 1);
	}
}
