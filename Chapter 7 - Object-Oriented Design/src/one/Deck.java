package one;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Deck {
	private List<Card> cards = new ArrayList<Card>();
	
	public Deck(String type) {
		AbstractCardFactory factory = CardFactoryProducer.getFactory(type);
		for (Rank rank: Rank.values()) {
			for (Suit suit: Suit.values()) {
				Card card = factory.getCard(suit, rank);
				cards.add(card);
			}
		}
	}
	
	public Card withdrawARandomCard() {
		if (cards.size() == 0) throw new NoSuchElementException();
		
		Random random = new Random();
		int number = random.nextInt(cards.size());
		Card card = cards.get(number);
		cards.remove(number);
		return card;
	}
}
