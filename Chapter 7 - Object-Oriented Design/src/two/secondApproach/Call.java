package two.secondApproach;

public class Call {
	
	private String message;
	private Rank rank;
	
	public Call(String message, Rank rank) {
		this.message = message;
		this.rank = rank;
	}
	
	public String getMessage() {
		return message;
	}

	public Rank getRank() {
		return rank;
	}

	
	

}
