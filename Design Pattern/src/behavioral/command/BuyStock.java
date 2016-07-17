package behavioral.command;

public class BuyStock implements Order {
	private Stock stock;
	
	public BuyStock(Stock aStock) {
		stock = aStock;
	}

	public void execute() {
		stock.buy();
	}	
}
