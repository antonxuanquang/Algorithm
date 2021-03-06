package two.secondApproach;

public enum Rank {
	RESPONDENT(1), MANAGER(2), DIRECTOR(Integer.MAX_VALUE);
	
	private int rank;
	
	Rank(int rank) {
		this.rank = rank;
	}
	
	int getValue() {
		return rank;
	}
}
