package one;

public class BlackJackCardFactory extends AbstractCardFactory {
	@Override
	Card getCard(Suit suit, Rank rank) {
		return new BlackJackCard(suit, rank);
	}
}
