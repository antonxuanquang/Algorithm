package behavioral.command;

public class SellStock implements Order {
	
	private Stock stock;
	
	public SellStock(Stock aStock) {
		stock = aStock;
	}

	public void execute() {
		stock.sell();
	}
	
	
}
