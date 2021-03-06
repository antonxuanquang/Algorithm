package one;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> cardsOnHand = new ArrayList<Card>();
	private String name;

	public Hand(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void witdrawACard(Deck deck) {
		cardsOnHand.add(deck.withdrawARandomCard());
	}

	public List<Card> getCards() {
		return cardsOnHand;
	}

}
