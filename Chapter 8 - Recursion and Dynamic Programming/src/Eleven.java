import java.util.HashMap;


public class Eleven {
	
	/*
	 * 
	 * Coins: given an infinite number of quarters (25 cents), dimes (10 cents), 
	 * nickels (5 cents), and pennies (1 cent), write code to calculate the 
	 * number of ways of representing n cents.
	 * 
	 */
	
	public static int makeChange(int amount, int[] denoms, int index, int[][] map) {
		if (map[amount][index] > 0) return map[amount][index];
		if (index >= denoms.length - 1) return 1; // one denom remaining -> one way to do it
		int denomAmount = denoms[index];
		int ways = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			int amountRemaining = amount - i * denomAmount;
			ways += makeChange(amountRemaining, denoms, index + 1, map); // go to next denom
		}
		map[amount][index] = ways;
		return ways;
	}
	
	public static int makeChange(int amount) {
		int[] denoms = {25, 10, 8,  5, 1};
		int[][] map = new int[amount + 1][denoms.length];
		return makeChange(amount, denoms, 0, map);
	}
	
	public static void main(String[] args) {
		int ways = makeChange(90000);
		System.out.println(ways);
	}
}

