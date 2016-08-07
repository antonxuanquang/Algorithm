package seven;

public class Seven {
	
	/*
	 * 
	 * Jigsaw: Implement an NxN jigsaw puzzle. Design the data structures and explain an algorithm
	 * to solve the puzzle. You can assume that you have a fitsWith method which, when passed 
	 * two puzzle edges, returns true if two edges belong together
	 * 
	 */
	
	public static void main(String[] args) {
		Piece piece = Puzzle.getARandomPiece();
		piece.rotate90degree();
	}

}
