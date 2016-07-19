package one;

public class One {
	
	/*
	 * 
	 * Design the data structures for a generic deck of cards. Explain how you would 
	 * subclass the data structures to implement blackjack
	 * 
	 */
	
	public static void main(String[] args) {
		Deck deck = new Deck("blackjack");
		BlackJackGame blackJack = new BlackJackGame();
		
		Hand quang = new Hand("Quang");
		Hand john = new Hand("John");
		
		quang.witdrawACard(deck);
		quang.witdrawACard(deck);
		
		john.witdrawACard(deck);
		john.witdrawACard(deck);
		
		blackJack.addHand(quang);
		blackJack.addHand(john);
		blackJack.checkAllHands();
	}
}