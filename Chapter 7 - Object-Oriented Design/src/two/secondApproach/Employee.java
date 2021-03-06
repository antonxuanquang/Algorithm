package two.secondApproach;

import java.util.List;

public abstract class Employee {
	
	protected String name;
	protected Rank rank;
	private Employee nextEmployee;
	
	public void dispatchCall(Call call, List<Call> pool) {
		if (rank.getValue() >= call.getRank().getValue()) {
			handleCall(call);
		} else {
			System.out.println(rank.name() + " " + name + " can't handle. Move to next level");
			pool.add(call);
		}
	}
	
	public void setNextlevel(Employee employee) {
		nextEmployee = employee;
	}
	
	abstract void handleCall(Call call);
}
