package seven;

public class WishPiece {
	
	private int column, row;
	private Piece piece;
	
	public WishPiece(Piece piece, int column, int row) {
		this.piece = piece;
		this.column = column;
		this.row = row;
	}
	
	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}


}
