package one;

import java.util.ArrayList;
import java.util.List;

public class BlackJackGame {
	private List<Hand> hands = new ArrayList<Hand>();
	
	public void addHand(Hand hand) {
		hands.add(hand);
	}
	
	public void checkAllHands() {
		for (Hand hand: hands) {
			System.out.println(hand.getName() + " got " + checkHand(hand)); 
		}
	}
	
	private int checkHand(Hand hand) {
		int sum = 0;
		for (Card card: hand.getCards()) {
			sum += card.getValue();
		}
		return sum;
	}
}
