package two;

public abstract class Employee {
	
	public static final int RESPONDENT = 1;
	public static final int MANAGER = 2;
	public static final int DIRECTOR = Integer.MAX_VALUE;
	
	protected Employee nextEmployee;
	protected int level;
	protected String name;
	
	public void dispatchCall(String message, int level) {
		if (this.level >= level) {
			handleCall(message);
		} else {
			System.out.println(name + " can't handle. Move to next level");
			nextEmployee.dispatchCall(message, level);
		}
	}
	
	public void setNextLevel(Employee employee) {
		this.nextEmployee = employee;
	}
	
	abstract void handleCall(String message); 
}
