package seven;

import java.util.ArrayList;
import java.util.LinkedList;

public class Puzzle {
	
	private Piece [][] puzzle;
	private LinkedList<WishPiece> wishList;
	
	public static Piece getARandomPiece() {
		Edge top = Edge.randomEdge();
		Edge right = Edge.randomEdge();
		Edge left = Edge.randomEdge();
		Edge bottom = Edge.randomEdge();
		return new Piece(top, right, bottom, left);
	}
	
	public Puzzle(int dimension) {
		puzzle = new Piece[dimension][dimension];
	}
	
	public void solve() {
		while (!wishList.isEmpty()) {
			Piece piece = getARandomPiece();
			WishPiece wishPiece = matchWishList(piece, wishList);
			if (wishPiece != null) {
				addAPiece(wishPiece, wishList, puzzle);
			}
		}
	}

	private void addAPiece(WishPiece wishPiece,
			LinkedList<WishPiece> wishList, Piece[][] puzzle) {
		int column = wishPiece.getColumn();
		int row = wishPiece.getRow();
		
		assert puzzle[column][row] == null;
		puzzle[column][row] = wishPiece.getPiece();
		
		//
		
	}

	private WishPiece matchWishList(Piece piece, LinkedList<WishPiece> wishList) {
		for (WishPiece wishPiece: wishList) {
			if (piece.matchWith(wishPiece.getPiece())) {
				return wishPiece;
			}
		}
		return null;
	}
	
}
