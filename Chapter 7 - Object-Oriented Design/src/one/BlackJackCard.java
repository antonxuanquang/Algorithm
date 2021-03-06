package one;

public class BlackJackCard extends Card {

	public BlackJackCard(Suit suit, Rank rank) {
		super(suit, rank);
	}

	@Override
	int getValue() {
		if (rank == Rank.ACE) return 1;
		else if (rank == Rank.JACK 
				|| rank == Rank.QUEEN 
				|| rank == Rank.KING) return 10;
		else return rank.getRank();
	}

	

}
