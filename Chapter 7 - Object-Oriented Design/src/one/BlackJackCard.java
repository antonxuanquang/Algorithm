package one;

public class BlackJackCard extends Card {

	public BlackJackCard(Suit suit, Rank rank) {
		super(suit, rank);
	}

	@Override
	protected void setRank() {
		Rank.ACE.setRank(1);
		Rank.JACK.setRank(10);
		Rank.QUEEN.setRank(10);
		Rank.KING.setRank(10);
	}

}
