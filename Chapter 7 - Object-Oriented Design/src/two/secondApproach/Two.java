package two.secondApproach;

public class Two {
	/*
	 * 
	 * Design classes and data structures for respondent, manager, and director.
	 * Implement a method dispatchCall() which assigns a call the the first available
	 * employee
	 * 
	 */
	
	public static void main(String[] args) {
		CallPool pool = new CallPool();
		
		Employee respondent1 = new Respondent("respondent1", Rank.RESPONDENT);
		Employee respondent2 = new Respondent("respondent2", Rank.RESPONDENT);
		Employee respondent3 = new Respondent("respondent3", Rank.RESPONDENT);
		
		Employee manager1 = new Manager("manager1", Rank.MANAGER);
		Employee manager2 = new Manager("manager2", Rank.MANAGER);
		
		Employee director = new Director("director", Rank.DIRECTOR);
		
		respondent1.setNextlevel(manager1);
		respondent2.setNextlevel(manager2);
		respondent3.setNextlevel(manager1);
		
		manager1.setNextlevel(director);
		manager2.setNextlevel(director);
		
		pool.addRespondent(respondent1);
		pool.addRespondent(respondent2);
		pool.addRespondent(respondent3);
		pool.addManager(manager1);
		pool.addManager(manager2);
		pool.addDirector(director);
		
		Call call1 = new Call("hello1 respondent", Rank.RESPONDENT);
		Call call2 = new Call("hello2 respondent", Rank.RESPONDENT);
		Call call3 = new Call("hello3 respondent", Rank.RESPONDENT);
		Call call4 = new Call("hello4 manager", Rank.MANAGER);
		Call call5 = new Call("hello5 manager", Rank.MANAGER);
		Call call6 = new Call("hello6 director", Rank.DIRECTOR);
		Call call7 = new Call("hello7 director", Rank.DIRECTOR);
		
		pool.addCall(call1);
		pool.addCall(call2);
		pool.addCall(call3);
		pool.addCall(call4);
		pool.addCall(call5);
		pool.addCall(call6);
		pool.addCall(call7);
		
		pool.handleAllCalls();
		
	}
}
