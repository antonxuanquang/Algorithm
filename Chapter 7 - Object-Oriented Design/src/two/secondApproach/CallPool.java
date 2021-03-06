package two.secondApproach;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CallPool {
	
	private List<Call> respondentPool = new ArrayList<Call>();
	private List<Call> managerPool = new ArrayList<Call>();
	private List<Call> directorPool = new ArrayList<Call>();
	
	private List<Employee> respondents = new ArrayList<Employee>();
	private List<Employee> managers = new ArrayList<Employee>();
	private List<Employee> directors = new ArrayList<Employee>();
	
	public void addRespondent(Employee respondent) {
		respondents.add(respondent);
	}
	
	public void addManager(Employee manager) {
		managers.add(manager);
	}

	public void addDirector(Employee director) {
		directors.add(director);
	}
	
	public void addCall(Call call) {
		respondentPool.add(call);
	}
	
	public void handleAllCalls() {
		// thread handle calls in here
		
		Random random = new Random();
		while (!respondentPool.isEmpty()) {
			Employee employee = respondents.get(random.nextInt(respondents.size()));
			Call call = respondentPool.remove(0);
			employee.dispatchCall(call, managerPool);
		}
		
		while (!managerPool.isEmpty()) {
			Employee employee = managers.get(random.nextInt(managers.size()));
			Call call = managerPool.remove(0);
			employee.dispatchCall(call, directorPool);
		}
		
		while (!directorPool.isEmpty()) {
			Employee employee = directors.get(random.nextInt(directors.size()));
			Call call = directorPool.remove(0);
			employee.dispatchCall(call, directorPool);
		}
	}

}
