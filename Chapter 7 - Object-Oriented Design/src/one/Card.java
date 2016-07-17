package one;

public abstract class Card {
	
	protected Suit suit;
	protected Rank rank;
	
	public Card (Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public int getValue() {
		return rank.getRank();
	}
	
	abstract protected void setRank();
	
}
