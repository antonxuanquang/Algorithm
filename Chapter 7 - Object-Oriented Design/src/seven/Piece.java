package seven;

public class Piece {
	
	private Edge top, right, bottom, left;
	
	public Piece(Edge top, Edge right, Edge bottom, Edge left) {
		this.bottom = bottom;
		this.top = top;
		this.right = right;
		this.left = left;
	}

	public Edge getTop() {
		return top;
	}

	public void setTop(Edge top) {
		this.top = top;
	}

	public Edge getRight() {
		return right;
	}

	public void setRight(Edge right) {
		this.right = right;
	}

	public Edge getBottom() {
		return bottom;
	}

	public void setBottom(Edge bottom) {
		this.bottom = bottom;
	}

	public Edge getLeft() {
		return left;
	}

	public void setLeft(Edge left) {
		this.left = left;
	}
	
	public void rotate90degree() {
		Edge temp = top;
		top = left;
		left = bottom;
		bottom = right;
		right = temp;
	}
	
	public String toString() {
		return "[" + top + ", " + right + ", " + bottom + ", " + left + "]";
	}

	public boolean matchWith(Piece piece) {
		for (int i = 0; i < 4; i++) {
			if (left.match(piece.getLeft())
					&& right.match(piece.getRight())
					&& top.match(piece.getTop())
					&& bottom.match(piece.getBottom())) return true;
			piece.rotate90degree();
		}
		return false;
	}

}
