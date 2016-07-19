package two.secondApproach;

public class Director extends Employee{

	public Director(String name, Rank rank) {
		this.name = name;
		this.rank = rank;
	}
	
	@Override
	void handleCall(Call call) {
		System.out.println(rank.name() + " " + name 
				+ " handle call with message: " + call.getMessage());
	}
}
