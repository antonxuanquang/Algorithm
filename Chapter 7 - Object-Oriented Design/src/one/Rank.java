package one;

public enum Rank {
	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
	TEN(10), JACK, QUEEN, KING, ACE;
	
	private int rank;
	
	Rank() {}
	
	Rank(int value) {
		rank = value;
	}
	
	public void setRank(int value) {
		rank = value;
	}
	
	public int getRank() {
		return rank;
	}
}
