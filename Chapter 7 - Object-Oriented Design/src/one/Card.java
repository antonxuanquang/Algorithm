package one;

public abstract class Card {
	
	protected Suit suit;
	protected Rank rank;
	
	public Card (Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	abstract int getValue();
	
}
