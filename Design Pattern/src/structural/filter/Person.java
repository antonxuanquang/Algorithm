package structural.filter;

public class Person {
	private String name;
	private String gender;
	private String maritalStatus;
	
	public Person(String name, String gender, String status) {
		this.name = name;
		this.gender = gender;
		maritalStatus = status;
	}
	
	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}
}
