package one;

public class CardFactoryProducer {
	public static AbstractCardFactory getFactory(String type) {
		if (type.equalsIgnoreCase("blackjack")) {
			return new BlackJackCardFactory();
		} else {
			throw new NoSuchFieldError();
		}
	}
}
